SUMMARY = "OpenDsh dev image"

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_OpenDsh-Dev-Image-Yocto"

IMAGE_INSTALL_append = " opendsh-dev-packagegroup-apps"

inherit core-image-sato
require opendsh-image.bb