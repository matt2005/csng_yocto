SUMMARY = "OpenDsh production image"

inherit core-image
require core-image-sato

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_OpenDsh-Image-Yocto"

IMAGE_INSTALL_append = " opendsh-packagegroup-apps"
