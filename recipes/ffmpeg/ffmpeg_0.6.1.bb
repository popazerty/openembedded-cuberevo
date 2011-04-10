require ffmpeg.inc

LICENSE = "LGPLv2.1+"

DEPENDS += "schroedinger libgsm"

PE = "1"
PR = "r0"

DEFAULT_PREFERENCE = "1"

SRC_URI = "http://ffmpeg.org/releases/ffmpeg-${PV}.tar.bz2"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF_mipsel = "--arch=mips"
EXTRA_FFCONF_sh4 = "--arch=sh4"
EXTRA_FFCONF ?= ""

EXTRA_OECONF = " \
		--disable-static \
		--disable-ffserver \
		--disable-altivec \
		--disable-debug \
		--disable-asm \
		--disable-amd3dnow \
		--disable-amd3dnowext \
		--disable-mmx \
		--disable-mmx2 \
		--disable-sse \
		--disable-ssse3 \
		--disable-armv5te \
		--disable-armv6 \
		--disable-armv6t2 \
		--disable-armvfp \
		--disable-iwmmxt \
		--disable-mmi \
		--disable-neon \
		--disable-vis \
		--disable-yasm \
		--disable-indevs \
		--disable-outdevs \
		--disable-muxers \
		--enable-muxer=ogg \
		--enable-muxer=flac \
		--enable-muxer=aac \
		--enable-muxer=mp3 \
		--enable-muxer=h261 \
		--enable-muxer=h263 \
		--enable-muxer=h264 \
		--enable-muxer=mpeg1video \
		--enable-muxer=image2 \
		--disable-encoders \
		--enable-encoder=aac \
		--enable-encoder=mp3 \
		--enable-encoder=theora \
		--enable-encoder=h261 \
		--enable-encoder=h263 \
		--enable-encoder=h263p \
		--enable-encoder=ljpeg \
		--enable-encoder=mjpeg \
		--enable-encoder=png \
		--enable-encoder=mpeg1video \
		--disable-decoders \
		--enable-decoder=aac \
		--enable-decoder=mp3 \
		--enable-decoder=theora \
		--enable-decoder=h261 \
		--enable-decoder=h263 \
		--enable-decoder=h263i \
		--enable-decoder=h264 \
		--enable-decoder=mpeg2video \
		--enable-decoder=png \
		--enable-decoder=ljpeg \
		--enable-decoder=mjpeg \
		--enable-decoder=vorbis \
		--enable-decoder=flac \
		--enable-small \
		--enable-shared \
        --enable-pthreads \
        --disable-stripping \
        --cross-prefix=${TARGET_PREFIX} \
        --prefix=${prefix}/ \
        --enable-libgsm \
        --enable-libmp3lame \
        --enable-libschroedinger \
        --enable-libtheora  \
        --enable-libvorbis \
        --enable-swscale \
        --arch=${TARGET_ARCH} \
        --enable-cross-compile \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
		--target-os=linux \
        ${EXTRA_FFCONF} \
"

do_configure() {
	./configure ${EXTRA_OECONF}
}

