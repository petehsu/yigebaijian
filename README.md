# 一个摆件 (YiGeBaiJian)

[Click to jump to English Version](#english-version)

一个简洁优雅的Android时间显示应用，专注于时间的美学呈现。

## 功能特性

- 🕐 **实时时间显示** - 支持多种时间格式和精度
- 🎨 **自定义界面** - 可调节透明度、字体大小、颜色等
- 📊 **年度进度** - 直观显示年度时间进度
- 🌊 **动态效果** - 波浪动画和雨滴效果
- ⚙️ **丰富设置** - 多种显示选项和个性化配置

## 技术栈

- **语言**: Kotlin
- **框架**: Android Jetpack Compose
- **架构**: MVVM
- **最低支持**: Android API 21+

## 安装使用

1. 下载最新版本的APK文件
2. 在Android设备上安装
3. 打开应用即可使用

## 开发环境

- Android Studio
- Kotlin 1.9+
- Gradle 8.0+

## 版本历史

### v3.0 (当前版本)
- 新增歌词广播接收功能，支持与LyraPlayer等音乐软件联动
- 极简界面4支持实时显示歌词，无歌词时显示一言
- 优化广播接收机制，提高跨应用通信稳定性
- 完善Android 14+兼容性，符合最新安全要求
- 提升整体用户体验和功能完整性

### v2.0
- 修复年度进度界面毫秒显示更新缓慢的问题
- 添加主界面时间颜色设置功能
- 优化界面导航逻辑
- 完善年度进度网格显示
- 修复多项界面显示和交互问题

### v1.0
- 初始版本发布
- 基础时间显示功能
- 年度进度显示
- 基本设置功能

## 主要修复记录

本项目在开发过程中修复了多个重要问题，包括：

- **界面导航逻辑错误** - 修复左滑手势导航跳过界面的问题
- **年度进度网格显示** - 修复网格界面滚动和显示问题
- **时间实时更新** - 解决时间显示延迟和不同步问题
- **毫秒显示优化** - 提升毫秒级时间显示的流畅度
- **界面设置功能** - 添加时间颜色等个性化设置选项

## 详细bug修复记录

# Bug修复文档

本文档记录了在开发过程中发现并修复的所有bug。

## Bug #1: 界面导航逻辑错误

### 问题描述
- **发现时间**: 开发初期
- **问题**: 在`LifeProgressPanel`中的左滑手势导航逻辑错误
- **具体表现**: 左滑手势直接跳转到摆球界面，跳过了年度进度网格界面
- **预期行为**: 左滑应该导航到`GridProgressPanel`（年度进度网格界面）

### 根本原因
在`MainActivity.kt`的`LifeProgressPanel`组件中，左滑手势的处理逻辑错误地设置了`_showPendulumBallPanel.value = true`，直接跳转到摆球界面。

### 修复方案
修改`MainActivity.kt`中`LifeProgressPanel`的左滑手势处理逻辑：
```kotlin
// 修复前
if (dragAmount < -100) {
    _showPendulumBallPanel.value = true
}

// 修复后
if (dragAmount < -100) {
    _showHourglassProgress.value = true
}
```

### 修复结果
- 正确的导航流程：主界面（上滑）→ 年度进度面板（左滑）→ 生命进度面板（左滑）→ 年度网格面板（左滑）→ 摆球面板
- 所有界面导航逻辑正常工作

---

## Bug #2: 年度进度网格界面显示不完整

### 问题描述
- **发现时间**: 界面导航修复后
- **问题**: 年度进度网格界面只显示三行蓝色方块
- **具体表现**: 无法看到完整的365个日期方块
- **预期行为**: 应该显示完整的365个日期方块，代表一年中的每一天

### 根本原因
在`MainActivity.kt`的`GridProgressPanel`中，`LazyVerticalGrid`的`userScrollEnabled`参数被设置为`false`，禁用了滚动功能，导致只能看到前几行的内容。

### 修复方案
修改`MainActivity.kt`中`GridProgressPanel`的`LazyVerticalGrid`配置：
```kotlin
// 修复前
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    userScrollEnabled = false,  // 禁用滚动
    // ...
)

// 修复后
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    userScrollEnabled = true,   // 启用滚动
    // ...
)
```

### 修复结果
- 用户可以垂直滚动查看所有365个日期方块
- 正确的颜色编码：蓝色（过去的日子）、半透明（未来的日子）、发光白色（生日）
- 所有交互功能正常工作

---

## Bug #3: 年度进度网格界面布局优化

### 问题描述
- **发现时间**: 滚动功能修复后
- **问题**: 需要滚动才能查看所有365个方块，用户体验不佳
- **具体表现**: 用户需要滚动多次才能看到完整的年度进度
- **预期行为**: 在单个页面内显示所有365个方块

### 根本原因
原始的7列布局导致需要约52行来显示所有365个方块，超出了屏幕显示范围。

### 修复方案
优化`MainActivity.kt`中`GridProgressPanel`的布局配置：
```kotlin
// 修复前
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    modifier = Modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    userScrollEnabled = true
)

// 修复后
LazyVerticalGrid(
    columns = GridCells.Fixed(26),  // 增加列数
    modifier = Modifier.padding(2.dp),  // 减少内边距
    verticalArrangement = Arrangement.spacedBy(1.dp),  // 减少间距
    horizontalArrangement = Arrangement.spacedBy(1.dp),  // 减少间距
    userScrollEnabled = false  // 禁用滚动，因为所有内容都可见
)
```

### 修复结果
- 所有365个方块在单个页面内可见（约15行）
- 保持方块的正方形比例
- 保留所有交互功能和滑动导航
- 提升用户体验，无需滚动即可查看完整年度进度

---

## Bug #4: 景深壁纸前景图显示优化

### 问题描述
- **发现时间**: 景深壁纸功能测试期间
- **问题**: 界面切换时前景图突兀隐藏，用户体验不佳
- **具体表现**: 在上下滑动切换界面时，前景图会瞬间消失，造成视觉跳跃
- **预期行为**: 前景图应该平滑过渡，避免突兀的显示/隐藏效果

### 根本原因
原始实现使用条件判断直接控制前景图的显示/隐藏，没有过渡动画，导致视觉效果突兀。

### 修复方案
在`MainActivity.kt`的`ForegroundLayer`中实现透明度动画：
```kotlin
// 修复前
if (!_showMinimalUI.value && !_showAboutScreen.value &&
    // ... 其他条件判断
    ) {
    _foregroundUri.value?.let { uriString ->
        AsyncImage(
            model = uriString,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

// 修复后
val foregroundAlpha by animateFloatAsState(
    targetValue = if (!_showMinimalUI.value && !_showAboutScreen.value &&
        // ... 其他条件判断
        ) 1f else 0f,
    animationSpec = tween(durationMillis = 300),
    label = "foreground alpha"
)

_foregroundUri.value?.let { uriString ->
    AsyncImage(
        model = uriString,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(foregroundAlpha)
            .zIndex(1f),
        contentScale = ContentScale.Crop
    )
}
```

### 修复结果
- 前景图在界面切换时平滑淡入淡出
- 消除了突兀的视觉跳跃效果
- 保持了所有原有功能
- 提升了用户体验的流畅性

---

## Bug #5: 编译错误修复

### 问题描述
- **发现时间**: 景深壁纸优化后
- **问题**: 编译错误 "Unresolved reference 'zIndex'"
- **具体表现**: 代码无法编译，IDE报告zIndex修饰符未定义
- **预期行为**: 代码应该正常编译和运行

### 根本原因
在景深壁纸优化中使用了`zIndex`修饰符，但缺少相应的导入语句。

### 修复方案
在`MainActivity.kt`中添加缺失的导入语句：
```kotlin
// 添加导入
import androidx.compose.ui.zIndex
```

### 修复结果
- 编译错误已解决
- 景深壁纸功能正常工作
- 代码质量得到提升

---

## 总结

## Bug #6: 壁纸模糊功能兼容性修复

### 问题描述
用户反映调整模糊度滑块时壁纸没有模糊效果，双击设置壁纸模糊功能无效。

### 根本原因
1. **Android版本兼容性问题**：Jetpack Compose的`blur`修饰符只在Android 12 (API 31)及以上版本支持
2. **缺少版本检查**：代码没有针对不同Android版本提供兼容性处理
3. **用户反馈不足**：没有向用户说明当前设备是否支持模糊效果

### 解决方案

#### 1. 添加Android版本兼容性检查
```kotlin
// 在BackgroundLayer中添加版本检查
.let { modifier ->
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        // Android 12+ 支持原生模糊
        modifier.blur(blurRadius.dp)
    } else {
        // Android 12以下版本，使用alpha效果模拟模糊
        modifier.alpha(if (blurRadius > 0) 0.7f else 1f)
    }
}
```

#### 2. 添加用户提示信息
```kotlin
// 在模糊滑块中添加版本兼容性提示
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
    Text(
        text = "注意：当前Android版本不支持模糊效果，仅显示透明度变化",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    )
}
```

#### 3. 添加调试日志
```kotlin
// 添加调试信息帮助排查问题
LaunchedEffect(blurRadius) {
    Log.d("BlurDebug", "BackgroundLayer blur radius: $blurRadius, Android version: ${Build.VERSION.SDK_INT}")
}
```

### 修复结果
- ✅ **Android 12+设备**：支持真正的模糊效果
- ✅ **Android 12以下设备**：提供透明度变化作为替代效果
- ✅ **用户体验改进**：明确告知用户当前设备的支持情况
- ✅ **调试能力增强**：添加日志帮助后续问题排查

---

## 总结

### 修复的文件
- `MainActivity.kt` - 主要的界面逻辑和布局文件

### 修复的功能
1. **界面导航系统** - 修复了左滑手势的导航逻辑
2. **年度进度网格显示** - 修复了滚动问题并优化了布局
3. **用户体验** - 优化了界面布局，提升了可用性
4. **景深壁纸优化** - 实现了平滑的前景图过渡动画
5. **编译问题修复** - 解决了依赖导入缺失的编译错误
6. **模糊功能兼容性** - 解决了Android版本兼容性问题，提供了降级方案
7. **时间显示实时更新** - 修复了年度进度界面时间不实时更新的问题
8. **毫秒显示性能优化** - 将毫秒更新频率从16ms提升到8ms，提高显示流畅度
9. **界面单位设置同步** - 人生进度界面的时间单位现在完全与年度进度界面同步，移除了独立的单位设置
10. **摆球界面白天适配** - 添加了白天/夜晚主题切换，支持下雨效果
11. **格子界面白天模式优化** - 格子分割线在白天模式下改为黑色，生日格子在白天使用黄色，提升可视性

### 技术改进
- 正确的状态管理和界面导航
- 优化的网格布局配置
- 改进的用户交互体验
- 添加了动画效果提升用户体验
- 完善了导入依赖管理
- 增强了Android版本兼容性处理
- 统一了时间更新机制，确保所有界面的时间显示一致性
- 优化了毫秒更新性能，从60fps提升到120fps，减少视觉延迟
- 实现了完全的界面间设置同步，人生进度界面移除独立单位设置，直接使用年度进度界面的单位配置
- 完善了主题适配系统，摆球界面现在支持白天/夜晚自动切换和下雨效果

### 测试状态
所有修复的功能都已经过测试，确认：
- 界面导航流程正确
- 年度进度网格完整显示
- 景深壁纸功能流畅运行
- 模糊功能在不同Android版本下正常工作
- 年度进度界面时间实时更新正常工作
- 毫秒显示性能优化生效，显示更加流畅
- 年度进度界面毫秒更新速度修复，LaunchedEffect现在正确响应设置变化
- 主界面新增时间颜色设置功能，用户可在显示设置中自定义时间颜色
- 人生进度界面完全同步年度进度界面单位设置，独立单位设置已移除
- 摆球界面白天/夜晚主题切换正常，下雨效果适配正确
- 格子界面分割线和生日格子颜色在白天/夜晚模式下正确显示
- 格子界面添加智能颜色适配（分割线：白天黑色/夜晚白色，生日格子：白天黄色/夜晚白色）
- 所有交互功能正常工作
- 代码编译和运行无错误
- 无诊断错误或警告

---

## Bug #7: 年度进度界面时间显示不实时更新

### 问题描述
- **发现时间**: 用户反馈
- **问题**: 年度进度界面的秒和毫秒显示不是真正的实时更新
- **具体表现**: 在年度进度界面中，当选择显示秒或毫秒时，数值不会实时变化，始终显示界面初始化时的时间
- **预期行为**: 秒和毫秒应该实时更新，特别是在选择毫秒显示时应该有流畅的数值变化

### 根本原因
在`YearProgressPanel`组件中，`currentTime`变量使用了`LocalDateTime.now()`直接赋值，这只在组件初始化时获取一次时间，没有实时更新机制。与主界面和人生进度界面不同，年度进度界面缺少`LaunchedEffect`来定期更新时间状态。

### 解决方案

#### 1. 将静态时间改为动态状态
```kotlin
// 修复前
val currentTime = LocalDateTime.now()

// 修复后
val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
```

#### 2. 添加实时更新机制
```kotlin
// 实时更新时间
LaunchedEffect(Unit) {
    while (true) {
        currentTime.value = LocalDateTime.now()
        delay(if (settings.passedTimeUnit == CustomTimeUnit.MILLISECOND || settings.remainingTimeUnit == CustomTimeUnit.MILLISECOND) 16 else 1000)
    }
}
```

#### 3. 更新所有时间引用
```kotlin
// 修复前
val isDaytime = currentTime.hour in 6..18
val remainingDays = 365 - currentTime.dayOfYear

// 修复后
val isDaytime = currentTime.value.hour in 6..18
val remainingDays = 365 - currentTime.value.dayOfYear
```

#### 4. 智能更新频率
- **毫秒显示**: 16ms更新间隔（约60fps），确保流畅的毫秒变化
- **秒及以上单位**: 1000ms更新间隔，节省资源

### 修复结果
- ✅ **秒显示**: 每秒准确更新，显示当前精确秒数
- ✅ **毫秒显示**: 流畅的实时毫秒更新，提供精确的时间感知
- ✅ **性能优化**: 根据显示单位智能调整更新频率
- ✅ **一致性**: 与主界面和人生进度界面的时间更新机制保持一致
- ✅ **用户体验**: 提供真正的实时时间显示体验

---

## Bug #8: 年度进度界面毫秒显示更新缓慢

### 问题描述
- **发现时间**: 时间实时更新修复后
- **问题**: 年度进度界面"今年已经过去了..."的毫秒显示更新缓慢
- **具体表现**: 虽然时间本身实时更新，但进度百分比中的毫秒部分更新不够流畅
- **预期行为**: 毫秒进度应该流畅更新，与时间显示保持同步

### 根本原因
在`YearProgressPanel`中，progress计算只考虑了天数，没有包含小时、分钟、秒和毫秒的精确信息，导致毫秒级别的进度变化不明显。

### 解决方案

#### 1. 优化progress计算逻辑
```kotlin
// 修复前
val progress = passedDays.toFloat() / totalDaysInYear

// 修复后
val progress = run {
    val totalMillisecondsInYear = totalDaysInYear * 24 * 60 * 60 * 1000L
    val currentMillisecond = currentTime.value.nano / 1_000_000
    val passedMilliseconds = (passedDays - 1) * 24 * 60 * 60 * 1000L +
                           currentTime.value.hour * 60 * 60 * 1000L +
                           currentTime.value.minute * 60 * 1000L +
                           currentTime.value.second * 1000L +
                           currentMillisecond
    passedMilliseconds.toFloat() / totalMillisecondsInYear
}
```

#### 2. 提升毫秒更新频率
```kotlin
// 将毫秒更新间隔从16ms提升到8ms，实现更流畅的显示
delay(if (settings.passedTimeUnit == CustomTimeUnit.MILLISECOND || settings.remainingTimeUnit == CustomTimeUnit.MILLISECOND) 8 else 1000)
```

### 修复结果
- ✅ **精确进度计算**: progress现在包含完整的时分秒毫秒信息
- ✅ **流畅毫秒更新**: 从60fps提升到120fps，减少视觉延迟
- ✅ **同步显示**: 进度百分比与时间显示完全同步
- ✅ **性能优化**: 仅在需要毫秒显示时使用高频更新
- 2024-12-19: 修复年度进度界面"今年已经过去了..."毫秒显示更新缓慢的问题，改用与剩余时间一致的实时计算方式

---

*文档创建时间: 2024年*  
*最后更新: 年度进度界面毫秒显示优化完成后*

## 贡献

欢迎提交Issue和Pull Request来改进这个项目！

### 开发指南

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

### 报告问题

如果发现bug或有功能建议，请在 [Issues](../../issues) 页面提交。

## 许可证

[MIT License](LICENSE)

---

*项目开发者: 重庆幼儿师范高等专科学校人工智能技术与应用1班徐远豪Pete Hsu*  
*酷安：@请叫我徐总*  
*最后更新: 2025年06月06日*

---
<a id="english-version"></a>
<details>
<summary><strong>English Version / 点击查看英文版本</strong></summary>

<br>

# YiGeBaiJian (一个摆件)

A nifty, elegant Android app for displaying the time, with a focus on making it look good.

## What's Inside

- 🕐 **Real-time Clock** - Supports a variety of formats and precision levels.
- 🎨 **Customisable UI** - Tweak transparency, font size, colours, and all that jazz.
- 📊 **Year Progress** - Get a visual on how much of the year has slipped by.
- 🌊 **Dynamic Effects** - Snazzy wave and raindrop animations.
- ⚙️ **Loads of Settings** - Plenty of options to get it looking just right.

## Tech Stack

- **Language**: Kotlin
- **Framework**: Android Jetpack Compose
- **Architecture**: MVVM
- **Minimum API**: Android 21+

## Getting Started

1.  Grab the latest APK.
2.  Chuck it on your Android device and install it.
3.  Open it up. Bob's your uncle.

## Dev Environment

-   Android Studio
-   Kotlin 1.9+
-   Gradle 8.0+

## Version History

### v3.0 (The Current One)

*   Added lyrics broadcast reception feature, supporting integration with music apps like LyraPlayer.
*   Minimal Interface 4 now displays real-time lyrics, showing quotes when no lyrics available.
*   Optimized broadcast reception mechanism for improved cross-app communication stability.
*   Enhanced Android 14+ compatibility, meeting latest security requirements.
*   Improved overall user experience and feature completeness.

### v2.0

*   Fixed a sluggish millisecond display on the year progress screen.
*   Added a colour setting for the main clock.
*   Tidied up the navigation logic.
*   Polished the year progress grid view.
*   Squashed a few other UI and interaction bugs.

### v1.0

*   Initial release.
*   Basic time display.
*   Year progress view.
*   Basic settings.

## Major Fixes

Sorted out a few key issues during development:

*   **Dodgy Navigation** - Fixed a left-swipe gesture that was skipping a screen.
*   **Year Progress Grid** - Patched up scrolling and display problems.
*   **Live Time Updates** - Dealt with lag and sync issues.
*   **Millisecond Display** - Smoothed out the millisecond-level time display.
*   **UI Settings** - Added options for customising things like the time colour.

---

# Bug Squashing Diary

A log of all the bugs found and squashed during development.

## Bug #1: Funky Navigation Logic

*   **Spotted**: Early in development.
*   **The Gist**: A left-swipe gesture in the `LifeProgressPanel` was a bit wonky.
*   **What Happened**: Swiping left jumped straight to the pendulum ball screen, completely bypassing the year progress grid.
*   **What Should've Happened**: A left swipe should navigate to the `GridProgressPanel`.

### The Culprit

The swipe handling logic in `MainActivity.kt` for the `LifeProgressPanel` was mistakenly setting `_showPendulumBallPanel.value = true`, sending the user to the wrong screen.

### The Fix

Tweaked the `LifeProgressPanel`'s swipe handler in `MainActivity.kt`:

```kotlin
// Before
if (dragAmount < -100) {
    _showPendulumBallPanel.value = true
}

// After
if (dragAmount < -100) {
    _showHourglassProgress.value = true
}
```

### The Result

*   The navigation flow is now spot on: Main screen (swipe up) → Year Progress (swipe left) → Life Progress (swipe left) → Year Grid (swipe left) → Pendulum Ball.
*   All navigation is now working as it should.

---

## Bug #2: Year Progress Grid Not Showing Properly

*   **Spotted**: After the navigation fix.
*   **The Gist**: The year progress grid was only showing three rows of blue squares.
*   **What Happened**: You couldn't see all 365 day-squares.
*   **What Should've Happened**: It should display all 365 squares, one for each day of the year.

### The Culprit

In `GridProgressPanel` inside `MainActivity.kt`, the `userScrollEnabled` parameter for the `LazyVerticalGrid` was set to `false`, which, you guessed it, disabled scrolling.

### The Fix

Flicked the switch for `userScrollEnabled` in `MainActivity.kt`:

```kotlin
// Before
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    userScrollEnabled = false,  // Scrolling off
    // ...
)

// After
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    userScrollEnabled = true,   // Scrolling on
    // ...
)
```

### The Result

*   Users can now scroll vertically to see all 365 day-squares.
*   The colour-coding is correct: blue for past days, semi-transparent for future days, and a glowing white for your birthday.
*   All interactions are working as intended.

---

## Bug #3: Year Progress Grid Layout Optimisation

*   **Spotted**: After fixing the scrolling.
*   **The Gist**: Having to scroll to see all 365 squares was a bit of a pain.
*   **What Happened**: Users had to scroll a fair bit to see the whole year's progress.
*   **What Should've Happened**: All 365 squares should be visible on a single screen.

### The Culprit

The original 7-column layout meant about 52 rows were needed to show all 365 squares, which was too much for one screen.

### The Fix

Optimised the layout config for `GridProgressPanel` in `MainActivity.kt`:

```kotlin
// Before
LazyVerticalGrid(
    columns = GridCells.Fixed(7),
    modifier = Modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    userScrollEnabled = true
)

// After
LazyVerticalGrid(
    columns = GridCells.Fixed(26),  // More columns
    modifier = Modifier.padding(2.dp),  // Less padding
    verticalArrangement = Arrangement.spacedBy(1.dp),  // Less spacing
    horizontalArrangement = Arrangement.spacedBy(1.dp),  // Less spacing
    userScrollEnabled = false  // No need to scroll now
)
```

### The Result

*   All 365 squares are now visible on one screen (in about 15 rows).
*   The squares have kept their shape.
*   All interactive features and swipe navigation still work.
*   A much better user experience, no scrolling required.

---

## Bug #4: Depth Wallpaper Foreground Image Optimisation

*   **Spotted**: During testing of the depth wallpaper feature.
*   **The Gist**: The foreground image would abruptly disappear when switching screens, which looked a bit naff.
*   **What Happened**: When swiping up or down, the foreground image would vanish instantly, causing a visual jump.
*   **What Should've Happened**: The foreground image should transition smoothly.

### The Culprit

The original implementation used a simple conditional to show/hide the foreground image, with no transition animation.

### The Fix

Implemented a fade animation in the `ForegroundLayer` in `MainActivity.kt`:

```kotlin
// Before
if (!_showMinimalUI.value && !_showAboutScreen.value && /* ...other conditions... */) {
    _foregroundUri.value?.let { uriString ->
        AsyncImage(
            model = uriString,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

// After
val foregroundAlpha by animateFloatAsState(
    targetValue = if (!_showMinimalUI.value && !_showAboutScreen.value && /* ...other conditions... */) 1f else 0f,
    animationSpec = tween(durationMillis = 300),
    label = "foreground alpha"
)

_foregroundUri.value?.let { uriString ->
    AsyncImage(
        model = uriString,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(foregroundAlpha)
            .zIndex(1f),
        contentScale = ContentScale.Crop
    )
}
```

### The Result

*   The foreground image now fades in and out smoothly when switching screens.
*   No more jarring visual jumps.
*   All original functionality is intact.
*   A much slicker user experience.

---

## Bug #5: Compile Error Fix

*   **Spotted**: After the depth wallpaper optimisation.
*   **The Gist**: A compile error: "Unresolved reference 'zIndex'".
*   **What Happened**: The code wouldn't compile because the `zIndex` modifier was undefined.
*   **What Should've Happened**: The code should compile and run without a hitch.

### The Culprit

The `zIndex` modifier was used in the depth wallpaper fix, but its import was missing.

### The Fix

Added the missing import statement in `MainActivity.kt`:

```kotlin
// Add this import
import androidx.compose.ui.zIndex
```

### The Result

*   Compile error sorted.
*   The depth wallpaper feature works perfectly.
*   Code quality improved.

---

## Bug #6: Wallpaper Blur Compatibility Fix

*   **Spotted**: User feedback.
*   **The Gist**: Adjusting the blur slider didn't blur the wallpaper, and the double-tap to set blur wasn't working.

### The Culprit

1.  **Android Version Compatibility**: Jetpack Compose's `blur` modifier only works on Android 12 (API 31) and newer.
2.  **Missing Version Check**: The code didn't handle different Android versions.
3.  **Lack of User Feedback**: The app didn't tell users if their device supported the blur effect.

### The Solution

#### 1. Add Android Version Check

```kotlin
// In BackgroundLayer, add a version check
.let { modifier ->
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        // Android 12+ gets proper blur
        modifier.blur(blurRadius.dp)
    } else {
        // Older versions get an alpha effect to simulate it
        modifier.alpha(if (blurRadius > 0) 0.7f else 1f)
    }
}
```

#### 2. Add a Hint for the User

```kotlin
// Add a note in the blur slider
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
    Text(
        text = "Heads-up: Your Android version doesn't support the blur effect, so you'll see a change in transparency instead.",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    )
}
```

#### 3. Add Debug Logging

```kotlin
// Add debug info to help with troubleshooting
LaunchedEffect(blurRadius) {
    Log.d("BlurDebug", "BackgroundLayer blur radius: $blurRadius, Android version: ${Build.VERSION.SDK_INT}")
}
```

### The Result

*   ✅ **Android 12+ devices**: Get a proper blur effect.
*   ✅ **Devices below Android 12**: Get a transparency change as a fallback.
*   ✅ **Improved UX**: Users are now in the loop about what their device supports.
*   ✅ **Easier Debugging**: Added logs to help sort out future issues.

---

## Bug #7: Year Progress Time Not Updating in Real-Time

*   **Spotted**: User feedback.
*   **The Gist**: The seconds and milliseconds on the year progress screen weren't updating live.
*   **What Happened**: When showing seconds or milliseconds, the values were stuck at the time the screen was opened.
*   **What Should've Happened**: Seconds and milliseconds should update in real-time.

### The Culprit

In the `YearProgressPanel` component, `currentTime` was assigned with `LocalDateTime.now()` directly, grabbing the time only once. It was missing a `LaunchedEffect` to keep the time updated.

### The Solution

#### 1. Make the Time Dynamic

```kotlin
// Before
val currentTime = LocalDateTime.now()

// After
val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
```

#### 2. Add a Real-Time Update Mechanism

```kotlin
// Update time in real-time
LaunchedEffect(Unit) {
    while (true) {
        currentTime.value = LocalDateTime.now()
        delay(if (settings.passedTimeUnit == CustomTimeUnit.MILLISECOND || settings.remainingTimeUnit == CustomTimeUnit.MILLISECOND) 16 else 1000)
    }
}
```

#### 3. Update All Time References

```kotlin
// Before
val isDaytime = currentTime.hour in 6..18
val remainingDays = 365 - currentTime.dayOfYear

// After
val isDaytime = currentTime.value.hour in 6..18
val remainingDays = 365 - currentTime.value.dayOfYear
```

#### 4. Smart Update Frequency

*   **Milliseconds**: Update every 16ms (about 60fps) for a smooth display.
*   **Seconds & above**: Update every 1000ms to save resources.

### The Result

*   ✅ **Seconds display**: Updates accurately every second.
*   ✅ **Milliseconds display**: Smooth, real-time millisecond updates.
*   ✅ **Performance optimisation**: Smartly adjusts update frequency.
*   ✅ **Consistency**: Matches the time update logic of other screens.
*   ✅ **Better UX**: A proper real-time experience.

---

## Bug #8: Sluggish Millisecond Updates on Year Progress

*   **Spotted**: After the real-time update fix.
*   **The Gist**: The "Year has passed by..." millisecond display on the year progress screen was still a bit laggy.
*   **What Happened**: The progress percentage's millisecond part wasn't updating as smoothly as the time display.
*   **What Should've Happened**: The millisecond progress should be silky smooth.

### The Culprit

The progress calculation in `YearProgressPanel` only considered days, not the precise hours, minutes, seconds, and milliseconds.

### The Solution

#### 1. Tweak the Progress Calculation

```kotlin
// Before
val progress = passedDays.toFloat() / totalDaysInYear

// After
val progress = run {
    val totalMillisecondsInYear = totalDaysInYear * 24 * 60 * 60 * 1000L
    val currentMillisecond = currentTime.value.nano / 1_000_000
    val passedMilliseconds = (passedDays - 1) * 24 * 60 * 60 * 1000L +
                           currentTime.value.hour * 60 * 60 * 1000L +
                           currentTime.value.minute * 60 * 1000L +
                           currentTime.value.second * 1000L +
                           currentMillisecond
    passedMilliseconds.toFloat() / totalMillisecondsInYear
}
```

#### 2. Bump Up the Update Frequency

```kotlin
// Upped the millisecond update interval from 16ms to 8ms for a smoother display
delay(if (settings.passedTimeUnit == CustomTimeUnit.MILLISECOND || settings.remainingTimeUnit == CustomTimeUnit.MILLISECOND) 8 else 1000)
```

### The Result

*   ✅ **Precise progress**: The calculation now includes full h/m/s/ms info.
*   ✅ **Smooth milliseconds**: Update rate boosted from 60fps to 120fps, reducing visual lag.
*   ✅ **Synced display**: Progress percentage is now perfectly in sync with the time.
*   ✅ **Performance boost**: Only uses high-frequency updates when needed.

---

## Fancy Contributing?

Feel free to submit an Issue or a Pull Request to make this project even better. Cheers!

### How to Chip In

1.  Fork the repo.
2.  Create a feature branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

### Found a Bug?

If you spot a bug or have an idea for a feature, pop over to the [Issues](../../issues) page and let me know.

## Licence

[MIT License](LICENSE)

---

*Dev: Pete Hsu, Class 1, AI Tech & Application, Chongqing Preschool Education College*  
*Coolapk: @请叫我徐总*  
*Last updated: 6 June 2025*

</details>
