DESCRIPTION ?= "Browser made by mozilla"
DEPENDS += "alsa-lib"
SRC_URI += "file://mozilla-${PN}.png file://mozilla-${PN}.desktop"

PARALLEL_MAKE = ""
ARM_INSTRUCTION_SET = "arm"

MOZPV ?= "${PV}"

PACKAGES =+ "${PN}-inspector"

PACKAGES += "${PN}-sdk"

FILES_${PN}-inspector = "	${libdir}/${PN}-${MOZPV}/chrome/inspector* \
				${libdir}/${PN}-${MOZPV}/components/*nspector* \
				${libdir}/${PN}-${MOZPV}/extensions/inspector* \
				${libdir}/${PN}-${MOZPV}/defaults/preferences/inspector* \
				"
FILES_${PN} = "${bindir}/${PN} \
               ${datadir}/applications/ \
	       ${datadir}/pixmaps/ \
	       ${libdir}/${PN}-${MOZPV}/* \
	       ${libdir}/${PN}-${MOZPV}/.autoreg \
	       ${bindir}/defaults"
FILES_${PN}-dev += "${datadir}/idl ${bindir}/${PN}-config"
FILES_${PN}-sdk += "${libdir}/${PN}-devel-${MOZPV}"
FILES_${PN}-dbg += "	${libdir}/${PN}-*/.debug \
			${libdir}/${PN}-*/*/.debug \
			${libdir}/${PN}-*/*/*/.debug \	
			${libdir}/${PN}-*/*/*/*/.debug \
			${bindir}/.debug \
			"

export HOST_LIBIDL_CONFIG = "${STAGING_BINDIR_NATIVE}/libIDL-config-2"

# Due to sysroot we need to sed out references to the target staging when building the native version of xpidl
# Symptons of the failure include "gthread.h:344: error: size of array 'type name' is negative"
export HOST_LIBIDL_CFLAGS = "`${HOST_LIBIDL_CONFIG} --cflags | sed -e s:${STAGING_DIR_TARGET}:${STAGING_DIR_NATIVE}:g`"


do_install() {
	oe_runmake DESTDIR="${D}" destdir="${D}" install
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/mozilla-${PN}.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/mozilla-${PN}.png ${D}${datadir}/pixmaps/
	rm -f ${D}${libdir}/${PN}-*/TestGtkEmbed
	rm -f ${D}${libdir}/${PN}-*/defaults/pref/firefox-l10n.js

	# use locale settings
	grep -Rl intl.locale.matchOS ${D}${libdir}/${PN}-*/ \
	   | grep '.js$' \
	   | xargs -n 1 sed -i 's/\(pref("intl.locale.matchOS",\s*\)false)/\1true)/g'

	# disable application updating
	grep -Rl app.update.enabled ${D}${libdir}/${PN}-*/ \
	   | grep '.js$' \
	   | xargs -n 1 sed -i 's/\(pref("app.update.enabled",\s*\)true)/\1false)/g'
}

pkg_postinst_${PN}() {
	# work around requirement for root access on first startup
	chmod -R a+w ${libdir}/${PN}* ||true 
}

do_stage() {
	autotools_stage_all
}

# Force feed mozilla our ldflags
TARGET_CC_ARCH += " ${LDFLAGS} "

# We don't build XUL as system shared lib, so we can mark all libs as private
PRIVATE_LIBS = "libnssckbi.so \
                libxpcom.so \
                libplc4.so \
                libssl3.so \
                libfreebl3.so \
                libnss3.so \
                libnspr4.so \
                libmozjs.so \
                libxul.so \
                libplds4.so \
                libnssutil3.so \
                libsoftokn3.so \
                libnssdbm3.so \
                libsmime3.so \
                libnullplugin.so \
                libimgicon.so \
                libdbusservice.so \
                libbrowserdirprovider.so \
                libbrowsercomps.so \
                libnptest.so \
                libMyService.so \
                libmozgnome.so \
                libtestdynamic.so \
                libnkgnomevfs.so \
                libxpcomsample.so \
                libunixprintplugin.so \
"


