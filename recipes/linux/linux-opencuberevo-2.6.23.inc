require linux-opencuberevo.inc

SRCREV = "c59d7210272be29e3850aca3abbff76443f65d6f-fixed"
PR_INC = "r7"

RREPLACES_kernel = "kernel-2.6.23.17-0123-${MACHINE}"
RCONFLICTS_kernel = "kernel-2.6.23.17-0123-${MACHINE}"
RREPLACES_kernel-image = "kernel-image-2.6.23.17-0123-${MACHINE}"
RCONFLICTS_kernel-image = "kernel-image-2.6.23.17-0123-${MACHINE}"

SRC_URI += ""
