DESCRIPTION = "OpenCuberevo: W-LAN Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r7"

inherit task

#
# task-opencuberevo-wlan
#
DESCRIPTION_${PN} = "OpenCuberevo: W-LAN Support"
DEPENDS_${PN} = "enigma2"
RDEPENDS_${PN} = "\
  enigma2-plugin-systemplugins-wirelesslan \
  wireless-tools \
  wpa-supplicant \
"

# TIDEGLO: these modules actually can't be installed
WLAN_CRYPTO_MODULES = ""
WLAN_PCI_MODULES = ""
#WLAN_CRYPTO_MODULES = "\
#  kernel-module-aes-generic \
#  kernel-module-arc4 \
#  kernel-module-ecb \
#  kernel-module-cryptomgr \
#  kernel-module-crypto-hash \
#  kernel-module-aead \
#  kernel-module-pcompress \
#  kernel-module-crypto-blkcipher \
#  kernel-module-crypto-algapi \
#"
#
#WLAN_PCI_MODULES = "\
#  kernel-module-ath5k \
#"

WLAN_USB_MODULES = "\
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
  rt73-firmware \
  zd1211-firmware \
"

WLAN_USB_MODULES_LEGACY = "\
  wlan-rt73 \
  rt3070 \
"

#TIDEGLO: don't compile... must be fixed
#  r8712u \
#  zd1211b \

RDEPENDS_${PN}_append_cuberevo = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-100hd = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-100hd', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-mini2 = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini2', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-mini = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-9500hd = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-9500hd', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-2000hd = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-2000hd', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-250hd = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-250hd', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_cuberevo-mini-fta = "\
  ${@base_contains('PREFERRED_VERSION_linux-cuberevo-mini-fta', '2.6.23', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

