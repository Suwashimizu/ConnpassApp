package org.suwashizmu.connpassapp.module.entity

/**
 * Created by KEKE on 2018/10/08.
 * 興味のある分野の一覧、どんどん増やすよ
 */
enum class InterestCategory(val id: Int, val searchValue: String) {
    KOTLIN(1, "kotlin"),
    JAVA(2, "java"),
    PYTHON(3, "python"),
    RUBY(4, "ruby"),
    MACHINE_LEARNING(5, "機械学習"),
    AI(6, "人工知能"),
    ARCHITECTURE(7, "アーキテクチャ"),
    DESIGN(8, "デザイン"),
    JAVA_SCRIPT(9, "javascript"),
    C_SHAPE(10, "C#"),
    UNITY(11, "unity"),
    INFRASTRUCTURE(12, "インフラ"),
    SWIFT(13, "swift"),
    ANDROID(14, "android"),
    I_OS(15, "iOS"),
    EVENT(16, "イベント"),
    ELIXIR(17, "elixir"),
    UX(18, "ux"),
    SCALA(19, "scala")
}