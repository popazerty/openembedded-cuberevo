DESCRIPTION = "OpenCuberevo: Enigma Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-opencuberevo-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opencuberevo-enigma \
  task-opencuberevo-modem \
"

#
# task-opencuberevo-enigma
#
RPROVIDES_task-opencuberevo-enigma = "task-opencuberevo-ui"
DESCRIPTION_task-opencuberevo-enigma = "OpenCuberevo: Enigma Dependencies"
DEPENDS_task-opencuberevo-enigma = "\
  tuxbox-plugins \
  tuxbox-plugins-enigma \
  links-dream \
"
RDEPENDS_task-opencuberevo-enigma = "\
  enigma \
  ipkgpl \
  links-dream-plugin \
  tuxbox-plugin-master \
  tuxbox-plugin-mines  \
  tuxbox-plugin-pacman \
  tuxbox-plugin-snake \
  tuxbox-plugin-soko \
  tuxbox-plugin-sol \
  tuxbox-plugin-solitair \
  tuxbox-plugin-tank \
  tuxbox-plugin-tetris \
  tuxbox-plugin-tuxcom \
  tuxbox-plugin-tuxmail \
  tuxbox-plugin-tuxtxt \
  tuxbox-plugin-vierg \
  tuxbox-plugin-yahtzee \
  enigma-locale-cs enigma-locale-da \
  enigma-locale-de enigma-locale-el enigma-locale-es enigma-locale-et \
  enigma-locale-fi enigma-locale-fr enigma-locale-hr enigma-locale-hu \
  enigma-locale-is enigma-locale-it enigma-locale-lt enigma-locale-nl \
  enigma-locale-no enigma-locale-pl enigma-locale-pt enigma-locale-ro \
  enigma-locale-ru enigma-locale-sk enigma-locale-sl \
  enigma-locale-sv enigma-locale-tr \
  task-opencuberevo-modem \
"

# disabled languages: enigma-locale-ar enigma-locale-sr enigma-locale-ur

RDEPENDS_task-opencuberevo-enigma_append_cuberevo = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-100hd = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-mini2 = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-mini = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-250hd = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-2000hd = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-9500hd = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

RDEPENDS_task-opencuberevo-enigma_append_cuberevo-mini-fta = "\
  enigma-blindscan \
  tuxbox-plugin-satfind \
"

PACKAGE_ARCH_task-opencuberevo-enigma = "${MACHINE_ARCH}"

#
# task-opencuberevo-modem
#
DESCRIPTION_task-opencuberevo-modem = "OpenCuberevo: Modem Support"
RDEPENDS_task-opencuberevo-modem = "\
  enigma-modem \
  kernel-module-crc-ccitt \
  kernel-module-ppp-async \
  kernel-module-ppp-generic \
  kernel-module-slhc \
  update-modules \
"
 
