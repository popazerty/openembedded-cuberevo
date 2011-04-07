DESCRIPTION = "OpenCuberevo: DVB API v2 Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-opencuberevo-dvbapi \
  ${PACKAGES}\
"

#
# task-opencuberevo-dvbapi2
#
RPROVIDES_${PN} = "task-opencuberevo-dvbapi"
DESCRIPTION_${PN} = "OpenCuberevo: DVB API v2 Dependencies"
RDEPENDS_${PN} = "\
  dvbsnoop \
  dreambox-dvb-tools \
  tuxbox-stream \
"

