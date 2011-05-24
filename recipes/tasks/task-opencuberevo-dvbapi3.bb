DESCRIPTION = "OpenCuberevo: DVB API v3 Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r1"

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
  cuberevo-dvb-tools \
  dvbtraffic \
  sctzap \
"

