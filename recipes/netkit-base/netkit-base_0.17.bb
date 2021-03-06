SECTION = "base"
DESCRIPTION = "netkit-base includes the inetd daemon."
LICENSE = "BSD"
PR = "r2"

SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-base-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://mconfig.patch;patch=1 \
           file://gcc4_buildfix.patch;patch=1;pnum=1 \
           file://init \
           file://inetd.conf"

inherit update-rc.d

INITSCRIPT_NAME = "inetd"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 . stop 20 0 1 6 ."

EXTRA_OEMAKE = "-C inetd"

do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

EXTRA_CFLAGS_opencuberevo = "-I${STAGING_DIR_TARGET}${layout_includedir} -O2 -Wall -W -Wpointer-arith -Wbad-function-cast -Wcast-qual -Wstrict-prototypes -Wmissing-prototypes -Wmissing-declarations -Wnested-externs -Winline"

do_compile_opencuberevo () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' 'CFLAGS=${EXTRA_CFLAGS}' all
}

do_install () {
	install -d ${D}${sysconfdir}/init.d ${D}${sbindir}
	install -m 0755 inetd/inetd ${D}${sbindir}/inetd
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/inetd
	install -m 0644 ${WORKDIR}/inetd.conf ${D}${sysconfdir}
}

