# cuberevo.inc

EXTRA_IMAGEDEPENDS += "u-boot"

GLIBC_ADDONS ?= "ports,nptl,libidn"
GLIBC_EXTRA_OECONF ?= "--disable-profile --with-tls --without-fp --with-__thread"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "cuberevo-dvb-modules cuberevo-dvb-tools pcsc-lite ccid portmap openvpn openrdate fbset ffmpeg libass"
MACHINE_FEATURES += "kernel26"

PREFERRED_PROVIDER_virtual/kernel = "linux-${MACHINE}"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"

