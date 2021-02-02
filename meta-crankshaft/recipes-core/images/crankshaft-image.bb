SUMMARY = "Crankshaft production image"

inherit core-image
require core-image-sato

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

IMAGE_BASENAME = "${MACHINE}_Crankshaft-Image-Yocto"

IMAGE_INSTALL_append = " crankshaft-packagegroup-apps"
