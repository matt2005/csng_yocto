SUMMARY = "IVI Base image"

inherit core-image
require ../../meta/recipes-sato/images/core-image-sato.bb

LICENSE = "MIT"

### Qt ### 
IMAGE_INSTALL_append = " make cmake"
IMAGE_INSTALL_append = " qtbase-tools qtbase qtdeclarative qtimageformats qtmultimedia qtquickcontrols2 qtquickcontrols qtbase-plugins cinematicexperience liberation-fonts"
PACKAGECONFIG_FONTS_append_pn-qtbase = " fontconfig"

### Network support ### 
IMAGE_INSTALL_append = " openssh-sftp-server rsync"

### Sound ###
IMAGE_INSTALL_append = " gstreamer1.0-plugins-good gstreamer1.0-plugins-base gstreamer1.0-plugins-ugly"
LICENSE_FLAGS_WHITELIST_append = " commercial  commercial_gstreamer1.0-plugins-ugly commercial_gstreamer1.0-plugins-ugly"
PACKAGECONFIG_append_pn-qtmultimedia = " gstreamer alsa"

### Audio Streaming ###
DISTRO_FEATURES_append = " pulseaudio"
IMAGE_INSTALL_append = " pulseaudio pulseaudio-module-dbus-protocol pulseaudio-server pulseaudio-module-bluetooth-discover pulseaudio-module-bluetooth-policy pulseaudio-module-bluez5-device pulseaudio-module-bluez5-discover alsa-utils alsa-plugins"

### Video ###
HDMI_GROUP = "1"
HDMI_MODE = "4"

### Bluetooth  ###
MACHINE_FEATURES += " bluetooth"
CORE_IMAGE_EXTRA_INSTALL = " rsync "
DISTRO_FEATURES_append = " pi-bluetooth bluez5 bluetooth linux-firmware-bcm43430 linux-firmware-brcmfmac43430"
IMAGE_INSTALL_append = " pi-bluetooth bluez5 bluez5-testtools linux-firmware-bcm43430 i2c-tools hostapd dhcp-server udev-rules-rpi bridge-utils iptables linux-firmware-ralink linux-firmware-rtl8192ce linux-firmware-rtl8192cu linux-firmware-rtl8192su linux-firmware-rpidistro-bcm43430"
ENABLE_UART = "1"

### Debugging ###

IMAGE_INSTALL_append = " strace"
EXTRA_IMAGE_FEATURES += "tools-debug"