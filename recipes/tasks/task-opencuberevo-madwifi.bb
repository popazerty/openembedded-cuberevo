DESCRIPTION = "OpenCuberevo: madwifi Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opencuberevo-madwifi
#
DESCRIPTION_${PN} = "OpenCuberevo: madwifi Support"
DEPENDS_${PN} = "\
  madwifi-ng \
"

RDEPENDS_${PN} = "\
  madwifi-ng-modules \
"

