DESCRIPTION = "OpenCuberevo: DVD-Burn Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opencuberevo-dvdburn
#
DESCRIPTION_${PN} = "OpenCuberevo: DVD-Burning Support"
DEPENDS_${PN} = "enigma2"
RDEPENDS_${PN} = "\
  cdrkit \
  dvd+rw-tools \
  dvdauthor \
  enigma2-plugin-extensions-dvdburn \
  mjpegtools \
  python-imaging \
"

# Actually this seems useless for cuberevo
#  projectx \
