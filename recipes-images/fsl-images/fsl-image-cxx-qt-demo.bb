require dynamic-layers/qt5-layer/recipes-fsl/images/fsl-image-qt5.bb

DESCRIPTION = "Cxx-Qt Demo Image - Based on fsl-image-qt5"
LICENSE = "MIT"

TOOLCHAIN_HOST_TASK:append = " packagegroup-rust-cross-canadian-${MACHINE} "

IMAGE_INSTALL += " \
    demo-threading \
"
