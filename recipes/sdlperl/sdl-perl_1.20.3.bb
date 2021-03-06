DESCRIPTION = "Perl bindings for SDL"
SECTION = "libs"
HOMEPAGE = "http://sdl.perl.org/"
LICENSE = "GPL"
DEPENDS = "perl virtual/libsdl libsdl-image libsdl-gfx libsdl-ttf libsdl-mixer libsdl-net smpeg"
PR = "r1"

SRC_URI = "http://bloodgate.com/perl/sdl/pub/SDL_perl-${PV}.tar.gz"
S = "${WORKDIR}/SDL_perl-${PV}"

inherit cpan

do_configure_prepend() {
        # Search staging area for includes
        sed -i -e 's:/usr/\(local/\)\{0,1\}include:${STAGING_INCDIR}:g' Makefile.linux
        # smpeg.h isn't in a subdirectry
        sed -i -e 's:#include <smpeg/smpeg.h>:#include <smpeg.h>:g' SDL_perl.xs
}
