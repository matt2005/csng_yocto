SUMMARY = "OpenDsh production image"

inherit core-image
require ivi-base-image.bb

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_OpenDsh-Image-Yocto"

IMAGE_INSTALL_append = " opendsh-packagegroup-apps"