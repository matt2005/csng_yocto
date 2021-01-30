DESCRIPTION = "OpenDsh application package group"
SUMMARY = "OpenDsh package group - tools/apps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    ethtool \
    evtest \
    fbset \
    i2c-tools \
    memtester \
"