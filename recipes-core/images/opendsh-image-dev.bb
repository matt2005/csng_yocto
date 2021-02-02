SUMMARY = "OpenDsh dev image"
inherit core-image
require opendsh-image.bb
IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_OpenDsh-Dev-Image-Yocto"

IMAGE_INSTALL_append = " opendsh-dev-packagegroup-apps"
