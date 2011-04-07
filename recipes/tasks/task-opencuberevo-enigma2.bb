DESCRIPTION = "OpenCuberevo: Enigma2 Task for the OpenCuberevo Distribution"
SECTION = "opencuberevo/base"
LICENSE = "MIT"
PR = "r6"

inherit task

PROVIDES = "\
  task-opencuberevo-ui \
  ${PACKAGES} \
"

PACKAGES = "\
  task-opencuberevo-enigma2 \
"

#
# task-opencuberevo-enigma2
#
RPROVIDES_task-opencuberevo-enigma2 = "task-opencuberevo-ui"
DESCRIPTION_task-opencuberevo-enigma2 = "OpenCuberevo: Enigma2 Dependencies"
RDEPENDS_task-opencuberevo-enigma2 = "\
  enigma2 \
  enigma2-defaultservices \
  enigma2-plugin-extensions-mediascanner \
  enigma2-plugin-systemplugins-frontprocessorupgrade \
  enigma2-plugin-systemplugins-hotplug \
  enigma2-plugin-systemplugins-networkwizard \
  enigma2-plugin-systemplugins-softwaremanager \
  enigma2-plugin-systemplugins-videotune \
  enigma2-streamproxy \
  tuxbox-tuxtxt-32bpp \
  enigma2-meta \
  enigma2-plugins-meta \
  enigma2-skins-meta \  
"

RRECOMMENDS_task-opencuberevo-enigma2 = "\
  aio-grab \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  enigma2-plugin-extensions-cutlisteditor \
  enigma2-plugin-extensions-graphmultiepg \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-extensions-webinterface \
  enigma2-plugin-systemplugins-satfinder \
  enigma2-plugin-systemplugins-positionersetup \
  enigma2-plugin-systemplugins-skinselector \
  ${@base_contains("MACHINE_FEATURES", "wifi", "task-opencuberevo-wlan", "", d)} \
  ${@base_contains("MACHINE_FEATURES", "modem", "task-opencuberevo-modem", "", d)} \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo = "\
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-100hd = "\
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-mini = "\
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-mini2 = "\
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-250hd = "\
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-2000hd = "\
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-9500hd = "\
  enigma2-plugin-systemplugins-commoninterfaceassignment \
  enigma2-plugin-systemplugins-videomode \
"

RDEPENDS_task-opencuberevo-enigma2_append_cuberevo-mini-fta = "\
  enigma2-plugin-systemplugins-videomode \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-100hd = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-mini = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-mini2 = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-mini-fta = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-250hd = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-2000hd = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

RRECOMMENDS_task-opencuberevo-enigma2_append_cuberevo-9500hd = "\
  task-opencuberevo-cdplayer \
  task-opencuberevo-dvdplayer \
  task-opencuberevo-dvdburn \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
