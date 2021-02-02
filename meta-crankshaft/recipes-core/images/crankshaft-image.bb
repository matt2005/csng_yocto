SUMMARY = "Crankshaft production image"

inherit core-image
require meta/recipes-sato/images/core-image-sato

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_Crankshaft-Image-Yocto"

IMAGE_INSTALL_append = " crankshaft-packagegroup-apps"
