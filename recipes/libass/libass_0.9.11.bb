DESCRIPTION = "libass library"
HOMEPAGE = "http://libass.googlecode.com/"
LICENSE = "GPL"

DEPENDS = "freetype"

SRC_URI = "http://libass.googlecode.com/files/libass-${PV}.tar.gz"

inherit autotools binconfig pkgconfig

EXTRA_OECONF = " \
	--host=${TARGET_SYS} \
        --disable-fontconfig \
	--prefix=${prefix}/ \
"

do_configure() {
	./configure ${EXTRA_OECONF}
}

