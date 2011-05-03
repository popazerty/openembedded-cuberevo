# cuberevo-sh4.inc

MACHINE_FEATURES += "alsa pci"

#OLDEST_KERNEL = "2.6.17"
OLDEST_KERNEL = "2.6.23"

PREFERRED_PROVIDER_task-opencuberevo-dvbapi = "task-opencuberevo-dvbapi3"
PREFERRED_PROVIDER_task-opencuberevo-ui = "task-opencuberevo-enigma2"

TARGET_ARCH = "sh4"

DISTRO_FEATURES += " mplt"

require conf/machine/include/cuberevo.inc
require conf/machine/include/tune-sh4.inc
