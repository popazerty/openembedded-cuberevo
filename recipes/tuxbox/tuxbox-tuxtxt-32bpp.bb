DEPENDS = "freetype dreambox-dvbincludes libtuxtxt"
DEPENDS_opencuberevo = "freetype cuberevo-dvbincludes libtuxtxt"
DESCRIPTION = "tuxbox tuxtxt for 32bit framebuffer"
MAINTAINER = "Sven Karschewski <seddi@i-have-a-dreambox.com>"

SRCDATE = "20090130"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxtxt;method=ext \
	file://makefiles.diff;patch=1;pnum=1 \
	file://nonblocking.diff;patch=1 \
	file://32bpp.diff;patch=1;pnum=1 \
	file://add_new_default_conf.diff;patch=1;pnum=1 \
	file://add_advanced_rc.diff;patch=1 \
	file://allow_different_demux.diff;patch=1 \
	file://plugin.py"

SRC_URI_opencuberevo = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxtxt;method=ext \
	file://makefiles.diff;patch=1;pnum=1 \
	file://nonblocking.diff;patch=1 \
	file://32bpp.diff;patch=1;pnum=1 \
	file://add_new_default_conf.diff;patch=1;pnum=1 \
	file://add_advanced_rc.diff;patch=1 \
	file://allow_different_demux.diff;patch=1 \
	file://plugin.py \
	file://plugin.h \
	file://tuxtxt.h \
	file://tuxtxt.c \
	file://tuxtxt_common.h \
	file://tuxtxt_def.h \
	file://stmfb.h"

FILES_${PN} = "/usr/bin/tuxtxt /usr/share/fonts/tuxtxt.otb /usr/lib/enigma2/python/Plugins/Extensions/Tuxtxt /etc/tuxtxt"

# tuxtxt.ttf comes from enigma2 git now
FILES_${PN}_append_powerpc = " /usr/share/fonts/tuxtxt.ttf"
RDEPENDS_${PN}_append_mipsel = " enigma2"

S = "${WORKDIR}/tuxtxt"

CFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"

do_configure_prepend() {
	touch ${S}/python/__init__.py
	install -m 0644 ${WORKDIR}/plugin.py ${S}/python
}

do_configure_prepend_opencuberevo() {
	touch ${S}/python/__init__.py
	install -m 0644 ${WORKDIR}/plugin.py ${S}/python
	install -m 0644 ${WORKDIR}/plugin.h ${S}
	install -m 0644 ${WORKDIR}/tuxtxt.h ${S}
	install -m 0644 ${WORKDIR}/tuxtxt.c ${S}
	install -m 0644 ${WORKDIR}/tuxtxt_common.h ${S}
	install -m 0644 ${WORKDIR}/tuxtxt_def.h ${S}
	install -m 0644 ${WORKDIR}/stmfb.h ${S}
}

do_stage() {
	install -m 0644 tuxtxt.h ${STAGING_INCDIR}/
}
