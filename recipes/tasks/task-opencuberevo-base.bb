DESCRIPTION = "OpenCuberevo: Base Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r5"

inherit task

#
# task-opencuberevo-base
#
DESCRIPTION_${PN} = "OpenCuberevo: Basesystem utilities"

OPENCUBEREVO_BASE_ESSENTIAL = "\
  autofs \
  base-files-doc \
  cuberevo-bootlogo \
  cuberevo-compat \
  cuberevo-feed-configs \
  cuberevo-keymaps \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  fakelocale \
  netkit-base \
  opkg-nogpg \
  timezones-alternative \
  tuxbox-common \
  util-linux-sfdisk \
  vsftpd \
  hdparm \
"

OPENCUBEREVO_BASE_RECOMMENDS = "\
  dropbear \
  sambaserver \
  zeroconf \
"

OPENCUBEREVO_BASE_OPTIONAL_RECOMMENDS = "\
  gdbserver \
  hddtemp \
  joe \
  mc \
  ncdu \
  ppp \
  smartmontools \
  avahi-daemon \
"

RDEPENDS_${PN} = "\
	${OPENCUBEREVO_BASE_ESSENTIAL} \
"

RRECOMMENDS_${PN} = "\
	${OPENCUBEREVO_BASE_RECOMMENDS} \
	${OPENCUBEREVO_BASE_OPTIONAL_RECOMMENDS} \
"
