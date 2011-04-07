DESCRIPTION = "OpenCuberevo: Modem task for the OpenCuberevo distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opencuberevo-modem
#
DESCRIPTION_${PN} = "OpenCuberevo: Modem support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  cuberevo-modem-ppp-scripts \
  enigma2-plugin-extensions-modem \
  ppp \
"

# TIDEGLO: I don't know why but this modules can't be installed successfully on 2.6.23 kernel
#  kernel-module-ppp-async \
#  kernel-module-ppp-deflate \
#  kernel-module-ppp-generic \
#

PACKAGE_ARCH = "${MACHINE_ARCH}"
