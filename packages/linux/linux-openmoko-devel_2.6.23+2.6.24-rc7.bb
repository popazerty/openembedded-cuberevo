require linux.inc
require linux-openmoko.inc

DESCRIPTION = "Linux 2.6.x (development) kernel for FIC SmartPhones shipping w/ OpenMoko"
VANILLA_VERSION = "2.6.23"
KERNEL_RELEASE = "2.6.24-rc7"

KERNEL_VERSION = "${KERNEL_RELEASE}"

# If you use a rc, you will need to use this:
PV = "${VANILLA_VERSION}+${KERNEL_RELEASE}+svnr${SRCREV}"
PR = "r0"

KERNEL_IMAGETYPE = "uImage"
UBOOT_ENTRYPOINT = "30008000"

##############################################################
# source and patches
#
SRCREV_FORMAT = "patches-rconfig"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;tag=v2.6.24-rc7 \
           svn://svn.openmoko.org/branches/src/target/kernel/2.6.24.x;module=patches;proto=http;name=patches \
           svn://svn.openmoko.org/branches/src/target/kernel/2.6.24.x;module=config;proto=http;name=config "

S = "${WORKDIR}/git"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = 'fic-gta01|fic-gta02'

CMDLINE = "unused -- bootloader passes ATAG list"

###############################################################
# module configs specific to this kernel
#

# usb
module_autoload_ohci-hcd = "ohci-hcd"
module_autoload_hci_usb = "hci_usb"
module_autoload_g_ether = "g_ether"
# audio
module_autoload_snd-soc-neo1973-wm8753 = "snd-soc-neo1973-wm8753"
# sd/mmc
module_autoload_s3cmci = "s3cmci"

do_prepatch() {
        mv ${WORKDIR}/patches ${S}/patches && cd ${S} && quilt push -av
        mv patches patches.openmoko
        mv .pc .pc.old
        mv ${WORKDIR}/config/defconfig-${KERNEL_VERSION} ${WORKDIR}/defconfig
}

addtask prepatch after do_unpack before do_patch