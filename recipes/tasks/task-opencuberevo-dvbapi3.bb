DESCRIPTION = "OpenCuberevo: DVB API v3 Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-opencuberevo-dvbapi \
  ${PACKAGES}\
"

#
# task-opencuberevo-dvbapi3
#
RPROVIDES_${PN} = "task-opencuberevo-dvbapi"
DESCRIPTION_${PN} = "OpenCuberevo: DVB API v3 Dependencies"
RDEPENDS_${PN} = "\
  dvbsnoop \
  dreambox-dvb-tools-v3 \
  dvbtraffic \
  sctzap \
"

