require u-boot.inc

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
           file://mpc8313e-rdb-autoboot.patch;patch=1 \
           file://mpc8313e-rdb-mtdparts.patch;patch=1 \
           file://mpc8313e-rdb-nand.patch;patch=1"

SRC_URI_append_opencuberevo = " \
           file://u-boot-1.3.1-stm-20080319.patch.gz;patch=1;pnum=1 \
           file://u-boot-1.3.1-sha1-header-fix.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1-stmmac_fix.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0034-20080610.patch.gz;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0036-20080801.patch.gz;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0038-20081014.patch.gz;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0043.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0044.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0045.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0046.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0047.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0049.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0050.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0051.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0052.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0053.patch;patch=1;pnum=1 \
           file://u-boot-1.3.1_stm23_0032_cuberevo.patch;patch=1"
