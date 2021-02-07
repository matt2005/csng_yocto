DESCRIPTION = "OpenDsh Dev application package group"
SUMMARY = "OpenDsh Dev package group - tools/apps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    aasdk \
    openauto \
    dash \
"