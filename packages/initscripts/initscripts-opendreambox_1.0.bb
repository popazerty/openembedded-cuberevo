DESCRIPTION = "SysV init scripts (stripped) for opendreambox"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
SECTION = "base"
PRIORITY = "required"
DEPENDS = "makedevs"
RDEPENDS = "makedevs"
LICENSE = "GPL"
PR = "r11"
PR_dm7025 = "r12"
PR_dm8000 = "r14"
PR_dm800 = "r12"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/${P}', '${FILE_DIRNAME}/initscripts-${PV}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"


SRC_URI = "file://halt \
           file://umountfs \
           file://reboot \
           file://single \
           file://sendsigs \
           file://rmnologin \
           file://umountnfs.sh \
           file://var.tar.gz.default \
           file://bootup"

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d \
		   ${D}${sysconfdir}/rcS.d \
		   ${D}${sysconfdir}/rc0.d \
		   ${D}${sysconfdir}/rc1.d \
		   ${D}${sysconfdir}/rc2.d \
		   ${D}${sysconfdir}/rc3.d \
		   ${D}${sysconfdir}/rc4.d \
		   ${D}${sysconfdir}/rc5.d \
		   ${D}${sysconfdir}/rc6.d \
		   ${D}${sysconfdir}/default

	install -m 0755    ${WORKDIR}/halt		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/reboot		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rmnologin	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/sendsigs		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/single		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/umountnfs.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/bootup  ${D}${sysconfdir}/init.d

	install -m 0755    ${WORKDIR}/var.tar.gz.default ${D}${sysconfdir}/var.tar.gz

#
# Install device dependent scripts
#
	if [ "${MACHINE}" = "dm600pvr" -o "${MACHINE}" = "dm500plus" ]; then
		head -n 4 ${WORKDIR}/umountfs > ${D}${sysconfdir}/init.d/umountfs
		echo "cd /tmp" >> ${D}${sysconfdir}/init.d/umountfs
		tail -n 14 ${WORKDIR}/umountfs >> ${D}${sysconfdir}/init.d/umountfs
		chmod 0755 ${D}${sysconfdir}/init.d/umountfs
		ln -sf /usr/bin/showshutdownpic ${D}${sysconfdir}/rc0.d/S89showshutdownpic
	else
		install -m 0755 ${WORKDIR}/umountfs	${D}${sysconfdir}/init.d/umountfs
	fi

	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc2.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc3.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc4.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc5.d/S99rmnologin
	ln -sf		../init.d/sendsigs	${D}${sysconfdir}/rc6.d/S20sendsigs
	ln -sf		../init.d/umountnfs.sh	${D}${sysconfdir}/rc6.d/S31umountnfs.sh
	ln -sf		../init.d/umountfs	${D}${sysconfdir}/rc6.d/S40umountfs
	ln -sf		../init.d/reboot	${D}${sysconfdir}/rc6.d/S90reboot
	ln -sf		../init.d/sendsigs	${D}${sysconfdir}/rc0.d/S20sendsigs
	ln -sf		../init.d/umountnfs.sh	${D}${sysconfdir}/rc0.d/S31umountnfs.sh
	ln -sf		../init.d/umountfs	${D}${sysconfdir}/rc0.d/S40umountfs
	ln -sf		../init.d/halt		${D}${sysconfdir}/rc0.d/S90halt
	ln -sf    ../init.d/bootup    ${D}${sysconfdir}/rcS.d/S00bootup
}