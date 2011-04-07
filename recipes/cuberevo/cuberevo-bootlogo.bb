DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

IMAGES_VERSION = "1"
BINARY_VERSION = "1"

PV = "${BINARY_VERSION}.${IMAGES_VERSION}"
PR = "r3"

SRC_URI = "file://audio.elf \
	file://video.elf \
	file://bootlogo.mvi"

S = "${WORKDIR}/"

ELF = "audio video"

MVI = "bootlogo"

do_install() {
	install -d ${D}/boot
	for i in ${ELF}; do
		install -m 0755 ${S}/$i.elf ${D}/boot/$i.elf;
	done;
	for i in ${MVI}; do
		install -m 0755 ${S}/$i.mvi ${D}/boot/$i.mvi;
	done;
}

pkg_preinst() {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postinst() {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}

pkg_prerm() {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postrm() {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share"
