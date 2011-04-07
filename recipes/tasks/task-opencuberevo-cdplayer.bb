DESCRIPTION = "OpenCuberevo: CD-Player Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opencuberevo-cdplayer
#
DESCRIPTION_${PN} = "OpenCuberevo: CD-Player Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
 kernel-module-cdfs \
 enigma2-plugin-extensions-cdinfo \
 libcddb \
 libcdio \
"

