DESCRIPTION = "Linux kernel for Cuberevo-mini-fta"
LICENSE = "GPL"
PN = "linux-cuberevo-mini-fta"
KV = "2.6.17"
#KV = "2.6.23"
PV = "2.6.17"
#PV = "2.6.23"

require linux-opencuberevo-2.6.17.inc
#require linux-opencuberevo-2.6.23.inc

PR="${PR_INC}.1"

SRC_URI += "\
	file://nosquashfs3.1.patch;patch=1 \
	file://squashfs3.0.patch;patch=1 \
	file://squashfs3.0_lzma.patch;patch=1 \
	file://linux-sh4-2.6.17.14_stm22_0037.mini_fo.diff;patch=1 \
	file://do-printk.patch;patch=1 \
	file://ktime_p0041.patch;patch=1 \
	file://hrtimer_p0041.patch;patch=1 \
	file://linuxdvb_p0041.patch;patch=1 \
	file://sound_p0041.patch;patch=1 \
	file://copo_p0041.patch;patch=1 \
	file://stm-dma_p0041.patch;patch=1 \
	file://sched_p0041.patch;patch=1 \
	file://timer_stm22.patch;patch=1 \
	file://p0041_cmdline_printk.patch;patch=1 \
	file://p0041_strcpy.patch;patch=1 \
	file://kernel22_depmod.patch;patch=1 \
	file://linux-v4l.patch;patch=1 \
	file://cuberevo_patches_p0041.patch;patch=1 \
	file://cuberevo_fdma_p0041.patch;patch=1 \
	file://cuberevo_i2c_p0041.patch;patch=1 \
	file://cuberevo_rtl8201_p0041.patch;patch=1 \
	file://cuberevo-mini-fta_setup_p0041.patch;patch=1 \
	file://cuberevo-mini-fta_defconfig"

SRC_URI_stm23 += "\
	file://linuxdvb_stm23_0123.patch;patch=1 \
	file://time_stlinux23_0123.diff;patch=1 \
	file://cpp_stm23_0123.patch;patch=1 \
	file://mtd_stm23_0123.patch;patch=1 \
	file://cmdline_printk_stm23_0123.patch;patch=1 \
	file://kernel23_depmod_0123.patch;patch=1 \
	file://sound_stm23_0123.diff;patch=1 \
	file://cuberevo_patches_stlinux23_0123.patch;patch=1 \
	file://cuberevo_rtl8201_stlinux23_0123.patch;patch=1 \
	file://cuberevo-mini-fta_setup_stlinux23_0123.patch;patch=1 \
	file://gcc-4.3-compilation-fix.diff;patch=1 \
	file://cuberevo-mini-fta_defconfig"

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/cuberevo-mini-fta_defconfig ${S}/.config
	oe_runmake oldconfig
}