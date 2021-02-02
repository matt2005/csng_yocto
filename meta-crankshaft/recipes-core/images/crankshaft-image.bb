SUMMARY = "Crankshaft production image"

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_Crankshaft-Image-Yocto"

IMAGE_INSTALL_append = " crankshaft-packagegroup-apps"

inherit core-image-sato