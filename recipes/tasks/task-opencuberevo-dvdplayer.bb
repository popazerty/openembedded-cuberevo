DESCRIPTION = "OpenCuberevo: DVD-Player Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opencuberevo-dvdplayer
#
DESCRIPTION_${PN} = "OpenCuberevo: DVD-Player Support"
DEPENDS_${PN} = "enigma2
RDEPENDS_${PN} = "\
  enigma2-plugin-extensions-dvdplayer \
"

# TIDEGLO: I don't know why but this modules can't be installed successfully on 2.6.23 kernel
#  kernel-module-udf \
#  kernel-module-isofs \
#
