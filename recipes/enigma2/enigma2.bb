DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native \
	libfribidi libxmlccwrap libdreamdvd gstreamer gst-plugin-dvbmediasink \
	gst-plugins-bad gst-plugins-good gst-plugins-ugly python-wifi"
DEPENDS_opencuberevo = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	cuberevo-dvbincludes freetype libdvbsi++ python swig-native \
	libfribidi libxmlccwrap libdreamdvd gstreamer gst-plugin-dvbmediasink \
	gst-plugins-bad gst-plugins-good gst-plugins-ugly python-wifi"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-fcntl gst-plugin-decodebin gst-plugin-decodebin2 python-stringold \
	python-pickle gst-plugin-app \
	gst-plugin-id3demux gst-plugin-mad gst-plugin-ogg gst-plugin-playbin \
	gst-plugin-typefindfunctions gst-plugin-audioconvert gst-plugin-audioresample \
	gst-plugin-wavparse python-netclient gst-plugin-mpegstream \
	gst-plugin-flac gst-plugin-dvbmediasink gst-plugin-mpegdemux gst-plugin-dvdsub \
	gst-plugin-souphttpsrc gst-plugin-mpegaudioparse gst-plugin-subparse \
	gst-plugin-apetag gst-plugin-icydemux gst-plugin-autodetect \
	glibc-gconv-iso8859-15 ethtool"

GST_RTSP_RDEPENDS = "gst-plugin-udp gst-plugin-rtsp gst-plugin-rtp gst-plugin-rtpmanager"
GST_ALSA_RDEPENDS = "gst-plugin-alsa alsa-conf"
GST_MISC_RDEPENDS = "gst-plugin-matroska gst-plugin-qtdemux gst-plugin-vorbis gst-plugin-audioparsersbad"
GST_DVD_RDEPENDS = "gst-plugin-cdxaparse gst-plugin-cdio gst-plugin-vcdsrc"
GST_BASE_RDEPENDS = "${GST_ALSA_RDEPENDS} ${GST_MISC_RDEPENDS} ${GST_RTSP_RDEPENDS}"

RDEPENDS_append_dm7020 = " gst-plugin-ossaudio gst-plugin-ivorbisdec"
RDEPENDS_append_dm7025 = " ${GST_ALSA_RDEPENDS} gst-plugin-ivorbisdec"
RDEPENDS_append_dm800 = " ${GST_BASE_RDEPENDS} gst-plugin-ivorbisdec"
RDEPENDS_append_dm8000 = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm500hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm800se = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_dm7020hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"

DEPENDS_append_opencuberevo = " cuberevo-dvb-tools"
RDEPENDS_append_opencuberevo = " cuberevo-dvb-tools"

RDEPENDS_append_cuberevo = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-mini = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-mini2 = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-mini-fta = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-250hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-2000hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-9500hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"
RDEPENDS_append_cuberevo-100hd = " ${GST_BASE_RDEPENDS} ${GST_DVD_RDEPENDS} gst-plugin-avi"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-extensions-dvdplayer = "libdreamdvd0"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "twisted-web"
RCONFLICTS_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
RREPLACES_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "twisted-mail twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extenstions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts ppp"
RDEPENDS_enigma2-plugin-extensions-modem_opencuberevo = "cuberevo-modem-ppp-scripts ppp"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"

PN = "enigma2"
PR = "r1"

SRCDATE = "20110217"
SRCDATE_opencuberevo = "20110523"
SRCREV = "5e19a3f8a5e8ce8a4e2cb2b601a1b8ef3554e4be"
SRCREV_opencuberevo = "59a735aedc3a0c4b4e360f0a2a13ad1fc2a53753"
#SRCDATE is NOT used by git to checkout a specific revision
#but we need it to build a ipk package version
#when you like to checkout a specific revision of e2 you need
#have to specify a commit id or a tag name in SRCREV

# if you want experimental use
####################################################
BRANCH = "experimental"
BRANCH_opencuberevo = "master"
PV = "experimental-git${SRCDATE}"
PV_opencuberevo = "master-git${SRCDATE}"
#SRCREV = ""
####################################################

SRC_URI = "git://git.opendreambox.org/git/enigma2.git;protocol=git;branch=${BRANCH};tag=${SRCREV}"
SRC_URI_opencuberevo = "git://opencuberevo.git.sourceforge.net/gitroot/opencuberevo/enigma2cuberevo;protocol=git;branch=${BRANCH};tag=${SRCREV} \
						file://rc_cuberevo.png \
						file://rcold_cuberevo.png \
						file://rcpositions_cuberevo.xml \ 
						file://keymap_cuberevo.xml \
						file://rc_cuberevo_small.png \
						file://rcold_cuberevo_small.png \
						file://rcpositions_cuberevo_small.xml \ 
						file://keymap_cuberevo_small.xml \
						file://rc_cuberevo_mini.png \
						file://rcold_cuberevo_mini.png \
						file://rcpositions_cuberevo_mini.xml \ 
						file://keymap_cuberevo_mini.xml "
SRC_URI_append_dm7025 = " file://7025_pvr_device_compatibility.diff;patch=1;pnum=1"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts ${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

EXTRA_OECONF = " \
        BUILD_SYS=${BUILD_SYS} \
        HOST_SYS=${HOST_SYS} \
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
"

PLATFORM_CUBEREVO_cuberevo = " -DPLATFORM_CUBEREVO "
PLATFORM_CUBEREVO_cuberevo-250hd = " -DPLATFORM_CUBEREVO_250HD "
PLATFORM_CUBEREVO_cuberevo-mini-fta = " -DPLATFORM_CUBEREVO_MINI_FTA "
PLATFORM_CUBEREVO_cuberevo-mini = " -DPLATFORM_CUBEREVO_MINI "
PLATFORM_CUBEREVO_cuberevo-mini2 = " -DPLATFORM_CUBEREVO_MINI2 "
PLATFORM_CUBEREVO_cuberevo-2000hd = " -DPLATFORM_CUBEREVO_2000HD "
PLATFORM_CUBEREVO_cuberevo-9500hd = " -DPLATFORM_CUBEREVO_9500HD "
PLATFORM_CUBEREVO_cuberevo-100hd = " -DPLATFORM_CUBEREVO_100HD "

# I know this sucks a bit, but it works and I need it in this way
CPPFLAGS_opencuberevo += "${PLATFORM_CUBEREVO} -I${STAGING_INCDIR}/freetype2"

export CPPFLAGS

EXTRA_OECONF_append_opencuberevo = " \
		--enable-cuberevo \
"

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', '%s ', recursive=True, match_path=True, prepend=True)
}

RCONFLICTS_${PN} = "dreambox-keymaps"
RREPLACES_${PN} = "dreambox-keymaps tuxbox-tuxtxt-32bpp (<= 0.0+cvs20090130-r1)"
RCONFLICTS_${PN}_opencuberevo = "cuberevo-keymaps"
RREPLACES_${PN}_opencuberevo = "cuberevo-keymaps"

do_configure_prepend_cuberevo () {
	cp ${WORKDIR}/rc_cuberevo.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-mini () {
	cp ${WORKDIR}/rc_cuberevo.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-mini2 () {
	cp ${WORKDIR}/rc_cuberevo.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-mini-fta () {
	cp ${WORKDIR}/rc_cuberevo_small.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo_small.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo_small.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo_small.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-250hd () {
	cp ${WORKDIR}/rc_cuberevo_small.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo_small.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo_small.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo_small.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-2000hd () {
	cp ${WORKDIR}/rc_cuberevo.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-9500hd () {
	cp ${WORKDIR}/rc_cuberevo.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo.xml ${S}/data/keymap.xml
}

do_configure_prepend_cuberevo-100hd () {
	cp ${WORKDIR}/rc_cuberevo_mini.png ${S}/data/skin_default/rc.png
	cp ${WORKDIR}/rcold_cuberevo_mini.png ${S}/data/skin_default/rcold.png
	cp ${WORKDIR}/rcpositions_cuberevo_mini.xml ${S}/data/rcpositions.xml
	cp ${WORKDIR}/keymap_cuberevo_mini.xml ${S}/data/keymap.xml
}

# workaround for opkg <= 0.1.7+svnr455-r19.1
pkg_preinst_${PN} () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	if [ -f ${datadir}/fonts/tuxtxt.ttf ]; then
		cp -a ${datadir}/fonts/tuxtxt.ttf /tmp/tuxtxt.ttf
	fi
}
pkg_postinst_${PN} () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	if [ -f /tmp/tuxtxt.ttf -a ! -f ${datadir}/fonts/tuxtxt.ttf ]; then
		mv /tmp/tuxtxt.ttf ${datadir}/fonts/tuxtxt.ttf
	fi
}
