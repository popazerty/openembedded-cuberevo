DESCRIPTION = "FIC Neo Smartphone UI Environment"
AUTHOR = "M. Dietrich"
SECTION = "python/ui"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=pyneog"
S = "${WORKDIR}/pyneog"

do_compile() {
	:
}

do_install() {
	find . -name ".svn"|xargs rm -rf
	install -d ${D}${datadir}/pyneog
	for i in media *.py; do
		cp -a $i ${D}${datadir}/pyneog/
	done

	install -d ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 80pyneog ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} = "${datadir} ${bindir} ${sysconfdir}"

RCONFLICTS = "openmoko-session2"
RREPlACES = "openmoko-session2"
RDEPENDS = "task-python-efl"
PACKAGE_ARCH = "${MACHINE_ARCH}"