#
# Copyright (C) 2020 Grakn Labs
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

workspace(name = "graknlabs_examples")

################################
# Load @graknlabs_dependencies #
################################
load("//dependencies/graknlabs:dependencies.bzl", "graknlabs_dependencies")
graknlabs_dependencies()

# Load Antlr
load("@graknlabs_dependencies//builder/antlr:deps.bzl", antlr_deps = "deps")
antlr_deps()
load("@rules_antlr//antlr:deps.bzl", "antlr_dependencies")
antlr_dependencies()

# Load Bazel
load("@graknlabs_dependencies//builder/bazel:deps.bzl","bazel_common", "bazel_deps", "bazel_toolchain")
bazel_common()
bazel_deps()
bazel_toolchain()

# Load gRPC
load("@graknlabs_dependencies//builder/grpc:deps.bzl", grpc_deps = "deps")
grpc_deps()
load("@com_github_grpc_grpc//bazel:grpc_deps.bzl",
com_github_grpc_grpc_deps = "grpc_deps")
com_github_grpc_grpc_deps()
load("@stackb_rules_proto//java:deps.bzl", "java_grpc_compile")
java_grpc_compile()
load("@stackb_rules_proto//node:deps.bzl", "node_grpc_compile")
node_grpc_compile()

# Load Java
load("@graknlabs_dependencies//builder/java:deps.bzl", java_deps = "deps")
java_deps()
load("@graknlabs_dependencies//library/maven:rules.bzl", "maven")

# Load Kotlin
load("@graknlabs_dependencies//builder/kotlin:deps.bzl", kotlin_deps = "deps")
kotlin_deps()
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories()
kt_register_toolchains()

# Load NodeJS
load("@graknlabs_dependencies//builder/nodejs:deps.bzl", nodejs_deps = "deps")
nodejs_deps()
load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories")
node_repositories()
load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories", "yarn_install")

# Load Python
load("@graknlabs_dependencies//builder/python:deps.bzl", python_deps = "deps")
python_deps()
load("@rules_python//python:pip.bzl", "pip_repositories", "pip3_import")
pip_repositories()
pip3_import(
    name = "graknlabs_dependencies_ci_pip",
    requirements = "@graknlabs_dependencies//tool:requirements.txt",
)
load("@graknlabs_dependencies_ci_pip//:requirements.bzl",
graknlabs_dependencies_ci_pip_install = "pip_install")
graknlabs_dependencies_ci_pip_install()

# Load Docker
load("@graknlabs_dependencies//distribution/docker:deps.bzl", docker_deps = "deps")
docker_deps()

# Load Checkstyle
load("@graknlabs_dependencies//tool/checkstyle:deps.bzl", checkstyle_deps = "deps")
checkstyle_deps()

# Load Sonarcloud
load("@graknlabs_dependencies//tool/sonarcloud:deps.bzl", "sonarcloud_dependencies")
sonarcloud_dependencies()

# Load Unused Deps
load("@graknlabs_dependencies//tool/unuseddeps:deps.bzl", unuseddeps_deps = "deps")
unuseddeps_deps()

#####################################################################
# Load @graknlabs_bazel_distribution from (@graknlabs_dependencies) #
#####################################################################
load("@graknlabs_dependencies//distribution:deps.bzl", distribution_deps = "deps")
distribution_deps()

# Load Apt and RPM
load("@graknlabs_bazel_distribution//common:dependencies.bzl", "bazelbuild_rules_pkg")
bazelbuild_rules_pkg()
load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")
rules_pkg_dependencies()

# Load Docker
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
git_repository(
    name = "io_bazel_skydoc",
    remote = "https://github.com/graknlabs/skydoc.git",
    branch = "experimental-skydoc-allow-dep-on-bazel-tools",
)
load("@io_bazel_skydoc//:setup.bzl", "skydoc_repositories")
skydoc_repositories()
load("@io_bazel_rules_sass//:package.bzl", "rules_sass_dependencies")
rules_sass_dependencies()
load("@io_bazel_rules_sass//:defs.bzl", "sass_repositories")
sass_repositories()

# Load Github
load("@graknlabs_bazel_distribution//github:dependencies.bzl", "tcnksm_ghr")
tcnksm_ghr()

# Load NodeJS
load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories")
node_repositories()

# Load Python
git_repository(
    name = "io_bazel_rules_python",
    remote = "https://github.com/bazelbuild/rules_python.git",
    commit = "fdbb17a4118a1728d19e638a5291b4c4266ea5b8",
)
load("@io_bazel_rules_python//python:pip.bzl", "pip_repositories", "pip_import")
pip_repositories()
pip_import(
    name = "graknlabs_bazel_distribution_pip",
    requirements = "@graknlabs_bazel_distribution//pip:requirements.txt",
)
load("@graknlabs_bazel_distribution_pip//:requirements.bzl", graknlabs_bazel_distribution_pip_install = "pip_install")
graknlabs_bazel_distribution_pip_install()

##############################
# Load @graknlabs_grakn_core #
##############################
load("//dependencies/graknlabs:dependencies.bzl", "graknlabs_grakn_core")
graknlabs_grakn_core()

#######################################################
# Load @graknlabs_common (from @graknlabs_grakn_core) #
#######################################################
load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl", "graknlabs_common")
graknlabs_common()

######################################################
# Load @graknlabs_graql (from @graknlabs_grakn_core) #
######################################################
load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl", "graknlabs_graql")
graknlabs_graql()
load("@graknlabs_graql//dependencies/maven:artifacts.bzl", graknlabs_graql_artifacts = "artifacts")

#########################################################
# Load @graknlabs_protocol (from @graknlabs_grakn_core) #
#########################################################
load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl", "graknlabs_protocol")
graknlabs_protocol()
load("@graknlabs_protocol//dependencies/maven:artifacts.bzl", graknlabs_protocol_artifacts = "artifacts")

##############################################################
# Load @graknlabs_grabl_tracing (from @graknlabs_grakn_core) #
##############################################################
load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl", "graknlabs_grabl_tracing")
graknlabs_grabl_tracing()

###############################
# Load @graknlabs_client_java #
###############################
load("//dependencies/graknlabs:dependencies.bzl", "graknlabs_client_java")
graknlabs_client_java()
load("@graknlabs_client_java//dependencies/maven:artifacts.bzl", graknlabs_client_java_artifacts = "artifacts")

#################################
# Load @graknlabs_client_python #
#################################
load("//dependencies/graknlabs:dependencies.bzl", "graknlabs_client_python")
graknlabs_client_python()
pip3_import(
    name = "graknlabs_client_python_pip",
    requirements = "@graknlabs_client_python//:requirements.txt",
)
load("@graknlabs_client_python_pip//:requirements.bzl",
graknlabs_client_python_pip_install = "pip_install")
graknlabs_client_python_pip_install()

############################
# Load @graknlabs_examples #
############################
# for Java
load("//dependencies/maven:dependencies.bzl", "maven_dependencies")
maven_dependencies()

# for Node.js
load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories", "yarn_install")
node_repositories()
yarn_install(
    name = "npm",
    package_json = "//phone_calls/nodejs:package.json",
    yarn_lock = "//phone_calls/nodejs:yarn.lock"
)
load("@npm//:install_bazel_dependencies.bzl", "install_bazel_dependencies")
install_bazel_dependencies()

# for Python
pip3_import(
    name = "phone_calls_pip",
    requirements = "//phone_calls/python:requirements.txt"
)
load("@phone_calls_pip//:requirements.bzl",
phone_calls_pip_install = "pip_install")
phone_calls_pip_install()

###############
# Load @maven #
###############
maven(
    graknlabs_graql_artifacts +
    graknlabs_protocol_artifacts +
    graknlabs_client_java_artifacts
)

# ################################
# # Load Grakn Labs Dependencies #
# ################################
# load("//dependencies/graknlabs:dependencies.bzl",
#      "graknlabs_grakn_core", "graknlabs_client_java", "graknlabs_client_python", "graknlabs_build_tools")
# graknlabs_grakn_core()
# graknlabs_client_java()
# graknlabs_client_python()
# graknlabs_build_tools()

# load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl", "graknlabs_graql", "graknlabs_protocol")
# graknlabs_graql()
# graknlabs_protocol()

# load("@graknlabs_build_tools//distribution:dependencies.bzl", "graknlabs_bazel_distribution")
# graknlabs_bazel_distribution()


# ###########################
# # Load Bazel Dependencies #
# ###########################

# load("@graknlabs_build_tools//bazel:dependencies.bzl", "bazel_common", "bazel_deps",
#      "bazel_toolchain", "bazel_rules_docker", "bazel_rules_nodejs", "bazel_rules_python")
# bazel_common()
# bazel_deps()
# bazel_toolchain()
# bazel_rules_docker()
# bazel_rules_nodejs()
# bazel_rules_python()

# load("@rules_python//python:pip.bzl", "pip_repositories", "pip3_import")
# pip_repositories()


# #################################
# # Load Build Tools Dependencies #
# #################################

# pip3_import(
#     name = "graknlabs_build_tools_ci_pip",
#     requirements = "@graknlabs_build_tools//ci:requirements.txt",
# )
# load("@graknlabs_build_tools_ci_pip//:requirements.bzl",
# graknlabs_build_tools_ci_pip_install = "pip_install")
# graknlabs_build_tools_ci_pip_install()

# pip3_import(
#     name = "graknlabs_bazel_distribution_pip",
#     requirements = "@graknlabs_bazel_distribution//pip:requirements.txt",
# )
# load("@graknlabs_bazel_distribution_pip//:requirements.bzl",
# graknlabs_bazel_distribution_pip_install = "pip_install")
# graknlabs_bazel_distribution_pip_install()


# ###########################
# # Load Local Dependencies #
# ###########################

# # for Java

# load("//dependencies/maven:dependencies.bzl", "maven_dependencies")
# maven_dependencies()

# # for Node.js

# load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories", "yarn_install")
# node_repositories()

# yarn_install(
#     name = "npm",
#     package_json = "//phone_calls/nodejs:package.json",
#     yarn_lock = "//phone_calls/nodejs:yarn.lock"
# )

# load("@npm//:install_bazel_dependencies.bzl", "install_bazel_dependencies")
# install_bazel_dependencies()

# # for Python

# pip3_import(
#     name = "phone_calls_pip",
#     requirements = "//phone_calls/python:requirements.txt"
# )
# load("@phone_calls_pip//:requirements.bzl",
# phone_calls_pip_install = "pip_install")
# phone_calls_pip_install()


# ##############################
# # Load Protocol Dependencies #
# ##############################

# load("@graknlabs_build_tools//grpc:dependencies.bzl", "grpc_dependencies")
# grpc_dependencies()

# load("@com_github_grpc_grpc//bazel:grpc_deps.bzl",
# com_github_grpc_grpc_deps = "grpc_deps")
# com_github_grpc_grpc_deps()

# load("@stackb_rules_proto//java:deps.bzl", "java_grpc_compile")
# java_grpc_compile()


# ################################
# # Load Grakn Core Dependencies #
# ################################

# load("@graknlabs_grakn_core//dependencies/graknlabs:dependencies.bzl",
# "graknlabs_common", "graknlabs_console", "graknlabs_grabl_tracing")
# graknlabs_common()
# graknlabs_console()
# graknlabs_grabl_tracing()

# load("@graknlabs_grakn_core//dependencies/maven:dependencies.bzl",
# graknlabs_grakn_core_maven_dependencies = "maven_dependencies")
# graknlabs_grakn_core_maven_dependencies()

# load("@graknlabs_grabl_tracing//dependencies/maven:dependencies.bzl",
# graknlabs_grabl_tracing_maven_dependencies = "maven_dependencies")
# graknlabs_grabl_tracing_maven_dependencies()

# load("@graknlabs_build_tools//bazel:dependencies.bzl", "bazel_rules_docker")
# bazel_rules_docker()

# load("@graknlabs_bazel_distribution//common:dependencies.bzl", "bazelbuild_rules_pkg")
# bazelbuild_rules_pkg()


# ###########################
# # Load Graql Dependencies #
# ###########################

# # for Bazel
# load("@graknlabs_graql//dependencies/compilers:dependencies.bzl", "antlr_dependencies")
# antlr_dependencies()

# # for ANTLR programs
# load("@rules_antlr//antlr:deps.bzl", "antlr_dependencies")
# antlr_dependencies()

# load("@graknlabs_graql//dependencies/maven:dependencies.bzl",
# graknlabs_graql_maven_dependencies = "maven_dependencies")
# graknlabs_graql_maven_dependencies()


# ###################################
# # Load Client Python Dependencies #
# ###################################

# pip3_import(
#     name = "graknlabs_client_python_pip",
#     requirements = "@graknlabs_client_python//:requirements.txt",
# )

# load("@graknlabs_client_python_pip//:requirements.bzl",
# graknlabs_client_python_pip_install = "pip_install")
# graknlabs_client_python_pip_install()


# #####################################
# # Load Bazel Common Workspace Rules #
# #####################################

# # TODO: Figure out why this cannot be loaded at earlier at the top of the file
# load("@com_github_google_bazel_common//:workspace_defs.bzl", "google_common_workspace_rules")
# google_common_workspace_rules()
