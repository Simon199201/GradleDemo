import java.util.regex.Matcher
import java.util.regex.Pattern
//
class BuildUtils {
    def versionCode = 10000
    def versionName = '1.1.2'
    static getVersionCode1(){
        return 1
    }
    def getVersionName2(){
        return versionName
    }
    static getVersionName1(){
        return "1.1.1"
    }
//    /*平台*/
//    static final String PLATFORM_XIAOBAO = "xiaobao"
//    static final String PLATFORM_XIAOMEI = "xiaomei"
//    static final String PLATFORM_XIAOBAO_TAIWAN = "xiaobaotaiwan"
//
//    /*关键字*/
//
//    static final String KEY_VERSION_CODE_XIAOBAO = "XiaoBaoVersionCode"
//    static final String KEY_VERSION_CODE_XIAOMEI = "XiaoMeiVersionCode"
//    static final String KEY_VERSION_CODE_XIAOBAO_TAIWAN = "XiaoBaoTaiWanVersionCode"
//    static final String KEY_VERSION_NAME_XIAOBAO = "XiaoBaoVersionName"
//    static final String KEY_VERSION_NAME_XIAOMEI = "XiaoMeiVersionName"
//    static final String KEY_VERSION_NAME_XIAOBAO_TAIWAN = "XiaoBaoTaiWanVersionName"
//
//    static generateVersionCode(project) {
//        int versionCode = getVersionProperty(project, generateVersionCodeKey(project)) as int
//        println("--------------versionCode:${versionCode}")
//        return versionCode
//    }
//
//    static generateVersionName(project) {
//        String versionName = getVersionProperty(project, generateVersionNameKey(project))
//        println("--------------versionName:${versionName}")
//        return versionName
//    }
//
//    private static platform(project) {
////        String taskReqStr = project.rootProject.gradle.getStartParameter().getTaskRequests().toString()
////        if (!taskReqStr.contains("assemble")) {
////            return
////        }
////        println("--------------###1taskReqStr:"+taskReqStr)
////
////        String buildTypeName
////
////        Pattern xbtwpattern = Pattern.compile("assemblexiaobaotaiwan.+")
////        Matcher xbtwMatcher = xbtwpattern.matcher(taskReqStr)
////        if (xbtwMatcher.find()) {
////            buildTypeName = xbtwMatcher.group(0).toLowerCase()
////            println("------------xiaobaoTaiWanTypeName:${buildTypeName}")
////
////            if (buildTypeName.contains(PLATFORM_XIAOBAO_TAIWAN)) {
////                return PLATFORM_XIAOBAO_TAIWAN
////            }
////        }
////        println("--------------###2")
////
////
////        Pattern xbpattern = Pattern.compile("assembleXiaobao.+")
////        Matcher matcher = xbpattern.matcher(taskReqStr)
////        if (matcher.find()) {
////            buildTypeName = matcher.group(0).toLowerCase()
////            println("------------xiaobaoTypeName:${buildTypeName}")
////
////            if (buildTypeName.contains(PLATFORM_XIAOBAO)) {
////                return PLATFORM_XIAOBAO
////            }
////        }
////
////        Pattern xmpattern = Pattern.compile("assembleXiaomei.+")
////        Matcher xmMatcher = xmpattern.matcher(taskReqStr)
////        if (xmMatcher.find()) {
////            buildTypeName = xmMatcher.group(0).toLowerCase()
////            println("------------xiaomeiTypeName:${buildTypeName}")
////
////            if (buildTypeName.contains(PLATFORM_XIAOMEI)) {
////                return PLATFORM_XIAOMEI
////            }
////        }
//
//        return PLATFORM_XIAOBAO_TAIWAN
//    }
//
//    private static generateVersionCodeKey(project) {
//        if (platform(project) == PLATFORM_XIAOBAO) {
//            return KEY_VERSION_CODE_XIAOBAO
//        } else if (platform(project) == PLATFORM_XIAOMEI) {
//            return KEY_VERSION_CODE_XIAOMEI
//        } else if (platform(project) == PLATFORM_XIAOBAO_TAIWAN) {
//            return KEY_VERSION_CODE_XIAOBAO_TAIWAN
//
//        }
//
//        return KEY_VERSION_CODE_XIAOBAO
//    }
//
//    private static generateVersionNameKey(project) {
//        if (platform(project) == PLATFORM_XIAOBAO) {
//            return KEY_VERSION_NAME_XIAOBAO
//        } else if (platform(project) == PLATFORM_XIAOMEI) {
//            return KEY_VERSION_NAME_XIAOMEI
//        } else if (platform(project) == PLATFORM_XIAOBAO_TAIWAN) {
//            return KEY_VERSION_NAME_XIAOBAO_TAIWAN
//        }
//
//        return KEY_VERSION_NAME_XIAOBAO
//    }
//
//    static buildVersionCode(project) {
//        int versionCode = getVersionProperty(project, "versionCode") as int
//        int buildNumber = getBuildNumber(project)
//
//        if (buildNumber > 99) {
//            return "${versionCode}99" as int
//        }
//
//        if (buildNumber < 10) {
//            return "${versionCode}0${buildNumber}" as int
//        }
//
//        return "${versionCode}${buildNumber}" as int
//    }
//
//    static generateOutputApkVersion(project) {
//        String versionName = buildVersionName(project)
//        project.rootProject.file("build/version.tmp").text = versionName
//        println "VersionName => ${versionName}"
//    }
//
//    static buildVersionName(project) {
//        "${getVersionProperty(project, "versionName")}.${getBuildNumber(project)}"
//    }
//
//    private static getVersionProperty(project, propName) {
//        Properties props = new Properties()
//        File file = getVersionConfigFile(project)
//
//        if (file.exists()) {
//            props.load(new FileInputStream(file))
//        } else {
//            throw new IllegalStateException("ni lai gao xiao de ba!")
//        }
//
//        String value = props.getProperty(propName)
//
//        if (value == null || value.isEmpty()) {
//            throw new IllegalStateException("Kao! ni lai gao xiao de ba!")
//        }
//
//        return value
//    }
//
//    private static getVersionConfigFile(project) {
//        project.rootProject.file("versiolize.properties")
//    }
//
//    private static getBuildNumber(project) {
//        try {
//            int buildNumber = project.rootProject.file('build_number.tmp').text.trim() as int
//            return buildNumber % 100;
//        } catch (Exception e) {
//            println "get build number error message = ${e.message}"
//            return 99
//        }
//    }
//
//    static generateOutputApkFileName(project, gradle) {
//        String taskReqStr = gradle.getStartParameter().getTaskRequests().toString()
//        if (!taskReqStr.contains("assemble")) {
//            return
//        }
//
//        String buildTypeName
//        Pattern pattern = Pattern.compile("assemble(Release|Debug)")
//        Matcher matcher = pattern.matcher(taskReqStr)
//        if (matcher.find()) {
//            buildTypeName = matcher.group(1).toLowerCase()
//        } else {
//            return
//        }
//
//        String versionName = buildVersionName(project)
//        def fileName = "xiaobao-phone-${buildTypeName}-v${versionName}-${new Date().format("yyyyMMdd")}.apk"
//        project.rootProject.file("build/filename.tmp").text = fileName
//        println "fileName => ${fileName}"
//    }
//
//    /**
//     * 获取当前分支的最新修改的 revision number，用于崩溃时定位构建详情，对应行号
//     */
//    static fetchLastVCSRevisionNumber() {
//        try {
//            'git rev-parse --short HEAD'.execute().text.trim()
//        } catch (Exception e) {
//            "unfetch"
//        }
//    }
//
//    /**
//     * 获取当前分支的名称，用于崩溃时定位构建详情
//     */
//    static fetchCurrentBranchName() {
//        try {
//            'git rev-parse --abbrev-ref HEAD'.execute().text.trim()
//        } catch (Exception e) {
//            "unfetch"
//        }
//    }
}