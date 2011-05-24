DESCRIPTION = "Tools for Cuberevo"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

KV_cuberevo = "${@base_contains('PREFERRED_VERSION_linux-cuberevo', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo', '2.6.23', '20110522', '20090820', d)}"

#KV_cuberevo = "${@base_contains('PREFERRED_VERSION_linux-cuberevo', '2.6.17', '2.6.17.14_stm22_0041', '2.6.30', d)}"
#PV_cuberevo = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo', '2.6.17', '20110522', '20090820', d)}"

KV_cuberevo-100hd = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-100hd', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-100hd = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-100hd', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-mini-fta = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini-fta', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-mini-fta = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini-fta', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-250hd = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-250hd', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-250hd = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-250hd', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-2000hd = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-2000hd', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-2000hd = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-2000hd', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-9500hd = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-9500hd', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-9500hd = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-9500hd', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-mini = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-mini = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini', '2.6.23', '20110522', '20090820', d)}"

KV_cuberevo-mini2 = "${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini2', '2.6.23', '2.6.23.17_stm23_0123', '2.6.30', d)}"
PV_cuberevo-mini2 = "${KV}-${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini2', '2.6.23', '20110522', '20090820', d)}"

RDEPENDS = "kernel (${KV})"

#hack for broken busybox depmod (v4l-dvb dvb-core isn't automatically loaded on cpu load)
DEPENDS = " module-init-tools"
RDEPENDS_append_cuberevo = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-100hd = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-mini-fta = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-250hd = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-2000hd = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-9500hd = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-mini = " module-init-tools-depmod"
RDEPENDS_append_cuberevo-mini2 = " module-init-tools-depmod"

PR = "r2"
GCC ?= ""

SRC_URI = "http://enigma2.sifteam.eu/tmp/opencuberevo/cuberevo-dvb-tools-${MACHINE}-${PV}${GCC}.tar.bz2 \
			file://showiframe.c \
			file://showiframe.pro"

inherit qmake

UTILS = "showiframe"

S = "${WORKDIR}/showiframe"

TOOLSBIN = "cubefpctl devinit eplayer3 grab hdmi-control hdmi-info rset shmE2 stfbcontrol stfbset streamproxy ustslave vdstandby"

do_configure_prepend() {
	install -d ${S}/
	cd ${S}/
	echo "TEMPLATE=subdirs" > dmutils.pro
	echo "CONFIG=console" >> dmutils.pro
	echo "SUBDIRS=${UTILS}" >> dmutils.pro
	install -m 0644 ${WORKDIR}/showiframe.c	${S}/
	install -m 0644 ${WORKDIR}/showiframe.pro	${S}/
}

do_stage() {
	install -m 0755 ${WORKDIR}/libdreamdvd.so.0.0.0 ${D}/usr/lib/libdreamdvd.so.0.0.0
	install -m 0755 ${WORKDIR}/libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so.0.0.0
	ln -s libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so.0
	ln -s libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so
	install -m 0755 ${WORKDIR}/libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so.0.0.0
	ln -s libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so.0
	ln -s libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so
}

do_install() {
	install -d ${D}/bin/
	install -d ${D}/lib/
	install -d ${D}/lib/firmware/
	install -d ${D}/usr/lib/
	for i in ${TOOLSBIN}; do
		install -m 0755 ${WORKDIR}/$i ${D}/bin/$i;
	done;
	install -d ${D}/${bindir}/
	for u in ${UTILS}
	do
		install -m 0755 ${S}/${u}/${u} ${D}/${bindir}/
	done
#	install -m 0755 ${WORKDIR}/showiframe ${D}/${bindir}/
#	install -m 0755 ${WORKDIR}/libdreamdvd.so.0.0.0 ${D}/usr/lib/libdreamdvd.so.0.0.0
#	install -m 0755 ${WORKDIR}/libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so.0.0.0
#	ln -s libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so.0
#	ln -s libeplayer3.so.0.0.0 ${D}/lib/libeplayer3.so
#	install -m 0755 ${WORKDIR}/libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so.0.0.0
#	ln -s libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so.0
#	ln -s libmmeimage.so.0.0.0 ${D}/lib/libmmeimage.so
	install -m 0755 ${WORKDIR}/dvb-fe-cx24116.fw ${D}/lib/firmware/dvb-fe-cx24116.fw
	install -m 0755 ${WORKDIR}/audio.elf ${D}/lib/firmware/audio.elf
	install -m 0755 ${WORKDIR}/video.elf ${D}/lib/firmware/video.elf
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
