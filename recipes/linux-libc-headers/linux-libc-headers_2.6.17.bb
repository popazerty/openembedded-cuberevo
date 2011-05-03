require linux-libc-headers.inc

DEFAULT_PREFERENCE = "-1"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://dvb-api-2.6.17.patch;patch=1 \
           file://Kconfig.patch;patch=1 \
           file://autoconf.h \
           file://version.h "

SRC_URI_append_opencuberevo = "file://patch-2.6.17.14;patch=1;pnum=1 \
#	file://linux-2.6.17.8-mm6-mtd.patch;patch=1;pnum=1 \
	file://linux-2.6.17.8-sh-allpatches.patch;patch=1;pnum=1 \
	file://linux-2.6.17_stm22-gcc-4.1.patch;patch=1;pnum=1 \
	file://linux-2.6.17-squashfs-3.1.patch;patch=1;pnum=1 \
	file://linux-2.6.17-sh4.i2c_ssc_rtc_wdt.patch;patch=1;pnum=1 \
	file://linux-2.6.17-sh4-lirc.patch;patch=1;pnum=1 \
	file://linux-2.6.17.8-sh-allpatches-update1.patch;patch=1;pnum=1 \
	file://linux-2.6.17.8-sh4_coproc_frmw.patch;patch=1;pnum=1 \
	file://linux-2.6.17-sh4-4kstack_fix_and_gRB_extend.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34_sh_movmem_intrinsics.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-sh_export_flush_xxx_region.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-sh_export_sdivsi3_i4i.patch;patch=1;pnum=1 \
	file://linux-2.6.17.8-at24c_patch_bugzilla_584_v3.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-lirc-update.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-ssc_fix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-sh_make_ptrs_output_of_atomics.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-7109eth_phy.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-copro_frmw_cmd_line.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-sh_syscall_tracing_ordering.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-sh_gcc4_compiler_syms.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-proc_stat_esp_eip.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-stm22-34-stb7100ref_usb_pwr.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-fb_software_drawing_config.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-st_usb_pm_build.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-sh_pm_config.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stm_710x_fdma-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stm_ide_piodma-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stm_alsa_dma_7109-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stm_gpdma_obsolete-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-smsc911x-fdma.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stasc_init_fixes.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stasc_fdma-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-fbcon_switch.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8_stm22-34-stm_710x_fdma-0002.patch;patch=1;pnum=1 \
	file://linux-2.6.17-sh4-kgdb2.4.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.8-fbsplash.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-stpio_export_stpio_configure_pin.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-nfs_tcp_rpc_fix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-nfs_rpc_disconnectfix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035_stmmac_mc_fix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-export_flush_cache_page.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-sata_stm_scatter_gather_fix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-sh-tlbmiss-optim.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-sh_do_page_fault_sti.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-sata_spinup.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-stm_710x_fdma-0003.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22-0035-smsc911x-fdma-0002.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-stm_710x_fdma-0004.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-smsc911x-scattergather-0001.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-stasc-dma-fix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-i2c_capability_fix.patch;patch=1;pnum=1 \
	file://linux-2.6.17.13_stm22_0036_m41st85y_rtc.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.11.12_stm20-33-i2c-pio-cocoreffix.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.13_stm22_0035-st_m28wxx0_flashsupport.patch;patch=1;pnum=1 \
	file://linux-sh4-2.6.17.14_stm22_0036-stasc-dma-speedup.patch;patch=1;pnum=1 \
# kernel 37 released here
	file://linux-sh4-2.6.17.14_stm22_0037-copy-user-optim.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-sh4-2.6.17.14_stm22_0037-coproc_mem_fix.patch;patch=1;pnum=1;minrev=0038 \
#	file://linux-sh4-2.6.17.14_stm22_0037-ssc_vs_hdmi.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-2.6.17.14_stm22_0037-modify_spdif_fdma_bus_targ.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-2.6.17.14_stm22_0037_ALSA_update.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-sh4-2.6.17.14_stm22_0036-bigphysarea-export-syms.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-sh4-2.6.17.14_stm22_0037-smsc911x-v1.25r5.patch;patch=1;pnum=1;minrev=0038 \
	file://linux-sh4-2.6.17.14_stm22_0038-fix-set_mb-warnings.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-nwhwconfig.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-stmmac_rx_opt.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038.i2c_timeout_and_hwfifo.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038_kgdb_fixes.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038.ssc_source_clock_fix.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038_usb_hub_lock.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038_usb_bulk_storage_endpoint_fix.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-sh4-2.6.17.14_stm22_0038_spi_hw_fifo.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-sh4-2.6.17.14_stm22_0038_usb_settings_update.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-sh4-2.6.17.14_stm22_0038_asc_preempt_fix.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_sh4_stm23_0038.kconfig_gRB.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-stm-ide_piodma-0002.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-stm-710x-alsa-LR-ordering.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22-0038-hms1-bsp.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22-0038-cdrom-alloc-dma-buffers.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-pcm_read.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-fdma-firmware-update.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-smsc911x-paced-dma.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-udf-2.50.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-sh-cmdline-cleanup.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-bpa2.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-sh-entry-mova.patch;patch=1;pnum=1;minrev=0039 \
	file://linux-2.6.17.14_stm22_0038-ubc-reg-width.patch;patch=1;pnum=1;minrev=0039 \
# kernel 39 released here
	file://linux-2.6.17.14_stm22_0039-sh-dma-proc.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-i2c-spi-ssc-tidy.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-stm-coprocessor-7100-reset.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-signal_handler.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-thread_alloc.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-stmmac_ioctl_fix_dma_move.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-bpa2_alsa.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-entropyfix.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-unwind_improve.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-fbdev_tag_by_scantype_in_sysfs.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-hdmi_hotplug_pio.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-flush_cache_4096.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-smsc911x-dma-2d.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-stasc-uartclk.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-tmu1.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-freerunning_timer.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-lttng-0.9.5full.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-cache_flush_updates.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-kprobes.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-get_stack.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-kptrace.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-uaccess.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-misaligned_fixup_pc_fix.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-fdma_fix.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-mtd-kmalloc-once.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-mtd-physmap.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-mtd-change_to_mutex.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-stm-alsa-normalise-buffer.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-libata-data_xfer-backport.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-stm-sata-workarounds.patch;patch=1;pnum=1;minrev=0040 \
	file://linux-2.6.17.14_stm22_0039-coproc_procfs_fix.patch;patch=1;pnum=1;minrev=0040 \
# kernel 40 released here
	file://linux-2.6.17.14_stm22_0040-sh-parallel-build-fix.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040-sh-csum_ipv6_magic-module.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-sh4-2.6.17-usb_bitstuffing_workaround.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040_i2c-glitch-support.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14-stm22-0040_ide-module-build-fix.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14-stm22-0040_usb-module-build-fix.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040-new_stmmac.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040-vmsplice-unexploit.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22.coproc_fix.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040-spi_update.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0039-mb602update.patch;patch=1;pnum=1;minrev=0041 \
	file://linux-2.6.17.14_stm22_0040_missed_frame.patch;patch=1;pnum=1;minrev=0041 \
# kernel 41 released here
"

S = "${WORKDIR}/linux-${PV}"

do_configure () {
	case ${TARGET_ARCH} in
		alpha*)   ARCH=alpha ;;
		arm*)     ARCH=arm ;;
		cris*)    ARCH=cris ;;
		hppa*)    ARCH=parisc ;;
		i*86*)    ARCH=i386 ;;
		ia64*)    ARCH=ia64 ;;
		mips*)    ARCH=mips ;;
		m68k*)    ARCH=m68k ;;
		powerpc*) ARCH=ppc ;;
		s390*)    ARCH=s390 ;;
		sh*)      ARCH=sh ;;
		sparc64*) ARCH=sparc64 ;;
		sparc*)   ARCH=sparc ;;
		x86_64*)  ARCH=x86_64 ;;
	esac
	if test !  -e include/asm-$ARCH; then
		oefatal unable to create asm symlink in kernel headers
	fi
#	rm "include/asm"
	cp -pPR "include/asm-$ARCH" "include/asm"
	if test "$ARCH" = "arm"; then
		cp -pPR include/asm/arch-ebsa285 include/asm/arch
	elif test "$ARCH" = "sh"; then
		cp -pPR include/asm/cpu-${TARGET_ARCH} include/asm/cpu || die "unable to create include/asm/cpu"
	fi
}

do_compile () {
}

do_stage () {
	install -d ${STAGING_INCDIR}
	rm -rf ${STAGING_INCDIR}/linux ${STAGING_INCDIR}/asm ${STAGING_INCDIR}/asm-generic
	cp -pfLR include/linux ${STAGING_INCDIR}/
	cp -pfLR ${WORKDIR}/autoconf.h ${STAGING_INCDIR}/linux/
	cp -pfLR ${WORKDIR}/version.h ${STAGING_INCDIR}/linux/
	cp -pfLR include/asm ${STAGING_INCDIR}/
	cp -pfLR include/asm-generic ${STAGING_INCDIR}/
}

do_install() {
	install -d ${D}${includedir}
	cp -pfLR include/linux ${D}${includedir}/
	cp -pfLR ${WORKDIR}/autoconf.h ${D}${includedir}/linux/
	cp -pfLR ${WORKDIR}/version.h ${D}${includedir}/linux/
	cp -pfLR include/asm ${D}${includedir}/
	cp -pfLR include/asm-generic ${D}${includedir}/
}
