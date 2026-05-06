# Jetpack Compose（Android）学习计划与代码完成度

本文档面向本仓库 `compose-study`，用于跟踪 **Compose for Android** 的学习路线与示例代码落地进度。建议按阶段推进，每完成一项在「代码完成度」中勾选并补充提交说明。

---

## 读者与团队现状（重要）

参与学习与演练的同学多为 **Android 初中高级开发**，日常栈以 **Java + 传统 View 体系**（`Activity` / `Fragment` / XML / `RecyclerView` / 自定义 `View`）为主。本文档的 Roadmap **刻意从「为什么要迁移」写起**，再过渡到 Kotlin、Compose 声明式 UI，最后落到 **与旧页面混写、双向通信、渐进式替换**，避免「一上来就背 Composable API」却与业务现状脱节。

**隐含前提（不必一次到位，可按阶段补齐）**：

- 能读懂并编写基础 Kotlin（空安全、`val`/`var`、数据类、lambda、扩展函数）；新功能代码建议 **Kotlin 优先**，旧模块可继续 Java，通过互操作共存。
- 对 Android 生命周期、`ViewModel`、Gradle 模块结构有既有经验，可将 Compose 视为 **新的 UI 层**，业务层尽量复用已有思路。

---

## 学习与提交节奏、日期量化（宽松版）

面向 **日常工作间隙** 推进：不强求整块时间，以 **可持续** 为主；某天只做 15 分钟文档笔记或改两行也算数，避免「全有或全无」放弃节奏。

### 假设与换算（便于对照日历）

| 项 | 取值 |
|----|------|
| **起点日** | **2026-05-06（周三）**（以你打开本文档、开始打卡的日期为准；若更晚开始，整表顺延即可） |
| **名义投入** | 每天约 **0.5 小时**（30 分钟）本仓库学习或练习代码并提交 |
| **折合周容量** | 约 **3.5 小时 / 周**（按 7 天都算；若实际只有 **工作日 5 天**，则约 **2.5 小时 / 周**，下表「周数」请乘以约 **1.4**） |
| **缓冲** | 加班、故障值班周允许 **整周进度为 0**；计划已按偏松估算，不必愧疚 |

### 多久能「完成」——分三档目标（避免只有一个模糊终点）

1. **档 A：本仓库「第六章代码完成度」主干勾满（含依赖、列表、ViewModel、Insets、至少一条 UI 测试；互操作 6.7 可先只做 2 项）**  
   - 粗算 **约 8～11 周**（按 3.5 h/周）。  
   - **目标日期区间：2026-07-01 ～ 2026-07-22**（从 2026-05-06 起算）。  
   - 含义：学习笔记落在本仓库里可运行、可 Review，适合作为「Compose 入门结业」。

2. **档 B**：Roadmap 中阶段 0～5 的实践都在本仓库有过提交（含互操作 6.7 四项与路由参数等）  
   - 粗算 **约 14～18 周**（按 3.5 h/周）。  
   - **目标日期区间：2026-08-12 ～ 2026-09-09**。  
   - 含义：与真实业务「混写、通信」对齐，可独立在新旧混合模块里接小需求。

3. **档 C：含阶段 7 进阶（动画、手势、性能、无障碍等选修多项）**  
   - 在档 B 基础上再加 **约 8～14 周**。  
   - **目标日期区间：约 2026-10-07 ～ 2026-12-09**（跨度大因选修范围自选）。  
   - 含义：偏高级工程师拓展，可与业务并行、不阻塞档 A/B。

**结论（一句话）**：每天稳定半小时、按本仓库清单推进，**约 2～2.5 个月**可到 **档 A**；**约 3.5～4.5 个月**可到 **档 B**；进阶 **档 C** 视选修再 **加 2～3.5 个月**。若只有工作日练习，同档各 **+30%～40%** 日历时间。

### 与第三章阶段对齐的「建议日历」（从 2026-05-06 起，按每天 30 分钟、每周 7 天）

下列为 **建议完成区间**，非刚性 DDL；落后时优先保证 **档 A** 清单，阶段 7 可无限后移。

| 阶段 | 内容摘要 | 建议周数 | 建议完成日（含） |
|------|----------|----------|------------------|
| 0 | 共识、Why Compose、勾选本清单习惯 | ~1 周 | **2026-05-13** |
| 1 | Kotlin 够用集（与阶段 2 可重叠） | ~2.5 周 | **2026-05-27** |
| 2 | Compose 基础、Modifier、布局、Text、主题 | ~3 周 | **2026-06-17** |
| 3 | 状态、副作用、TextField、LazyColumn | ~3 周 | **2026-07-08** |
| 4 | Scaffold、Navigation、ViewModel、生命周期收集 | ~4 周 | **2026-08-05** |
| 5 | ComposeView / AndroidView、通信 Demo | ~3.5 周 | **2026-08-26** |
| 6 | 渐进迁移策略（文档化 + 业务切片，长期） | 并行，不设终点 | 与档 B/C 并行 |
| 7 | 动画、测试、性能等（选修） | 见档 C | 自选 |

### 每日 30 分钟可以怎么拆（降低启动成本）

- **10 分钟**：读一小节官方文档或本文档第二章对照表。  
- **15 分钟**：改本仓库一个极小 PR（一个 `@Preview`、一条路由、一个 `remember` 状态）。  
- **5 分钟**：`git commit` + 一句话说明（便于以后复盘）。

---

## 一、为什么要迁移到 Compose（给团队讲清楚的版本）

### 1.1 业务与协作层面

- **UI 即代码**：布局、状态、事件集中在 Kotlin 中，减少 XML 与 Java/Kotlin 双处修改、漏改 id、布局膨胀难读等问题；Code Review 更容易看到完整界面逻辑。
- **迭代效率**：列表、条件分支、主题切换等用声明式组合表达，通常比层层 `ViewStub` / 多套 XML 更短、更直观。
- **官方方向**：新 Jetpack API（如部分 Material、导航模式示例）以 Compose 为第一公民；长期维护的库会持续优化 Compose 路径。

### 1.2 技术与性能层面（需客观表述）

- **重组（Recomposition）** 有学习成本，但掌握 **状态模型** 与 **稳定性** 后，列表与动画的编写成本常低于 `Adapter` + `ViewHolder` 样板代码。
- **Material3**、动态颜色、无障碍语义等与 Compose 集成路径清晰；Edge-to-edge、WindowInsets 等新系统 UI 实践在 Compose 侧有统一 Modifier 故事。
- **不是要求一夜替换**：真实项目多为 **渐进式迁移**；旧 View 与 Compose 长期共存是常态，Google 亦提供 **互操作（Interop）** 能力。

### 1.3 团队何时「不必强迁」

若产品形态极度依赖大量成熟自定义 View、已有极重 XML 模板化体系，且无人力做渐进迁移，可 **新页 Compose、旧页维持**。本文档后续「混写与通信」章节即服务于此策略。

---

## 二、从 View 体系到 Compose：心智与组件对照（Java 背景友好）

学习组件时建议 **先想 View 里叫什么、数据从哪来、事件往哪去**，再映射到 Compose 的 **参数 + Modifier + 状态**；下列「相同 / 不同」帮助避免「按 TextView 的用法硬套 Text」。

### 2.1 宏观心智（总表）

| 传统 View / XML | Jetpack Compose | 备注 |
|-----------------|-----------------|------|
| XML + `findViewById` | `@Composable` 函数 + 参数 / `remember` | UI 树由函数调用描述，随状态自动刷新相关部分 |
| `setText` / `visibility = GONE` | `Text(...)` / `if (show) { … }` | 用 Kotlin 控制「显示什么」，而非命令式改 View |
| `onMeasure` / `onLayout` / `LayoutParams` | `Modifier` 链 + 内置布局 / 自定义 `Layout` | Modifier **顺序**影响测量与绘制，类似链式设置但语义更强 |
| `RecyclerView` + `Adapter` | `LazyColumn` + `items { }` | 注意 `key`、item 作用域与性能 |
| `LiveData.observe` | `collectAsStateWithLifecycle` / `State` | 推荐与 `ViewModel` + `StateFlow` 搭配 |
| `Context` / `AttributeSet` 主题 | `MaterialTheme` | `colorScheme`、`typography` 与主题资源对应 |
| `View.onClick` | `Modifier.clickable` / `Button(onClick)` | 注意点击区域与无障碍 |
| 多线程更新 UI | 仍须在主线程更新状态；副作用用 `LaunchedEffect` 等 | 与 Handler 规则一致，表达方式不同 |

**一句话**：View 是「拿到引用再改属性」；Compose 是「用数据描述界面，数据变则相关描述重算（重组）」。

### 2.2 组件级细化：与旧 View 对照（异同）

下表 **「相同」** 指业务语义或能力上可对应；**「不同」** 指实现模型或 API 习惯差异（迁移时最易踩坑处）。

#### 布局容器

| 旧 View / XML | Compose 侧 | 相同点 | 不同点 |
|---------------|-------------|--------|--------|
| `FrameLayout` | `Box` | 叠放子项、对齐到边角 | Compose 无 `layout_gravity` 字符串，用 `Modifier.align`（在 `BoxScope` 内）或子项顺序与 `fillMaxSize` 组合 |
| `LinearLayout`（竖） | `Column` | 线性排列 | `layout_weight` → `Modifier.weight(1f)`；注意 `weight` 须在可测量高度约束下使用 |
| `LinearLayout`（横） | `Row` | 同上 | 同上（横向 `weight`） |
| `RelativeLayout` | 多数用 `Box` + `align`，或 `ConstraintLayout`（Compose 版） | 相对定位语义 | Compose 更推荐 **简单 Column/Row/Box 组合**；复杂约束再用 `ConstraintLayout` |
| `ConstraintLayout`（XML） | `androidx.constraintlayout.compose.ConstraintLayout` | 链、屏障、比例等约束思路相近 | DSL 为 Kotlin；依赖需单独引入 compose 版 constraintlayout |
| `ScrollView` | `Modifier.verticalScroll(rememberScrollState())` 包裹单列内容 | 一列可滚动 | **一次性组合全部子项**；子项极多时性能不如 `LazyColumn` |
| `HorizontalScrollView` | `Modifier.horizontalScroll(rememberScrollState())` | 横向滚动 | 同上 |
| `ViewPager` / `ViewPager2` | `HorizontalPager`（Material3 / foundation） | 分页滑动 | API 为 Composable；与 `TabRow` 联动模式需单独学 |

#### 文本与富文本

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `TextView` | `Text` | 展示字符串、字号、颜色、行数省略 | 样式多用 `TextStyle` / `MaterialTheme.typography`；无 `setText` 多次刷新同一引用，而是 **重组时传入新 `text`** |
| `TextView` + `HTML.fromHtml` | `AnnotatedString` + `buildAnnotatedString` / `InlineTextContent`（复杂场景） | 富文本展示 | 模型为不可变数据；链接点击用 `ClickableText` 或 `LinkAnnotation`（随 BOM 选 API） |
| `TextView` drawable 相对文字 | `Text` + `inlineContent` 或自定义 `Row` 布局图标+文字 | 图文混排 | 习惯从「Span」转到「组合布局或 AnnotatedString」 |
| `EditText`（只读展示） | 仍可用 `Text`；若需可选中复制 | 展示 | 只读编辑框在 Compose 里通常直接用 `Text` + `SelectionContainer`（按需） |

#### 图片

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `ImageView` + `src` / `setImageDrawable` | `Image` + `painterResource` / `ImageVector` / `BitmapPainter` | 展示位图与矢量 | 网络图官方示例多用 **Coil / Glide Compose 集成**（`AsyncImage` 等），不是单一内置控件名 |
| `ImageView scaleType` | `ContentScale`（`Crop`、`Fit` 等） | 裁剪/适应语义相近 | 写在 `Image` 的 `contentScale` 参数 |

#### 按钮与点击区域

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `Button` | `Button`（Material3） | 主操作、圆角与主题色 | 子内容为 `@Composable () -> Unit`，不再 `setText` |
| `ImageButton` / 图标点击 | `IconButton` | 图标触达 | 需提供 `contentDescription` 无障碍 |
| 任意区域点击 | `Modifier.clickable` | 点击回调 | **Modifier 顺序**影响可点区域与是否被父项消费；需显式 `semantics` 时别漏无障碍 |

#### 输入框

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `EditText` | `OutlinedTextField` / `TextField` / `BasicTextField` | 输入、hint、单行多行 | 状态为 **受控组件**：`value` + `onValueChange` 必须由上层持有；类似 React 受控输入 |
| `addTextChangedListener` | `onValueChange` | 文本变化 | 不要在 `onValueChange` 里做重 IO；格式化可用 `VisualTransformation` |
| `TextInputLayout` 错误提示 | `isError` + `supportingText`（M3） | 错误态展示 | API 名称与 XML 属性不同，需查对应 M3 文档 |

#### 选择类控件

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `CheckBox` | `Checkbox` | 勾选状态 | `checked` + `onCheckedChange` 受控 |
| `Switch` | `Switch` | 开关 | 同上 |
| `RadioGroup` + `RadioButton` | `RadioButton` + 自行分组或用 `Row`/`Column` 管理选中项 | 单选语义 | 选中态通常绑定一个 **枚举/int 状态**，不是系统自动互斥 |
| `SeekBar` | `Slider` | 连续值选择 | 参数与步进在 Composable 上声明 |

#### 列表与「复用」

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `RecyclerView` + `Adapter` | `LazyColumn` / `LazyVerticalGrid` + `items` | 纵向列表、滑动 | **无 ViewHolder 类**；item 是 Composable；用 **`key { }`** 稳定身份，利于动画与状态 |
| `notifyDataSetChanged` | 更新 **List 状态** 即可 | 数据驱动刷新 | 细粒度刷新靠 **不可变列表 + 稳定 key**；滥用全量重组会变慢 |
| `ItemDecoration` 分割线 | `Divider` / `items` 间插入 / `Modifier.border` | 视觉分隔 | 写法更偏组合而非装饰器类 |
| `ListView` / 简单 `RecyclerView` | `LazyColumn` | 长列表 | 短列表仍可用 `Column` + `verticalScroll`，但要知性能边界 |

#### 表面与卡片

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `CardView`（圆角阴影） | `Card`（Material3） | 卡片容器 | `elevation` / `shape` 为参数；颜色跟 `MaterialTheme.colorScheme` |
| `MaterialCardView` | `Card` / `ElevatedCard` / `OutlinedCard` | M3 分层 | 命名与 XML Material 组件有映射，需对照设计稿选 variant |

#### 顶部栏、底部栏、脚手架

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `Toolbar` / `ActionBar` | `TopAppBar` / `CenterAlignedTopAppBar` 等 | 标题与导航图标 | 完全 Composable 组合；返回可用 `NavigationIcon` |
| `BottomNavigationView` | `NavigationBar` + `NavigationBarItem`（M3） | Tab 切换 | 与 `NavController` 联动模式见本仓库 `TabBarPage` |
| 多区域 + FAB + Snackbar | `Scaffold` | 经典应用骨架 | `paddingValues` / `innerPadding` 需 **统一处理 Insets**，否则与 Edge-to-edge 叠加易错位 |

#### 对话框与提示

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `AlertDialog` | `AlertDialog`（compose.material3） | 确认/取消 | 内容为 Composable slot；显示与否由 **是否调用该 Composable**（如 `if (show)`) 控制 |
| `PopupWindow` / `DropdownMenu`（View） | `DropdownMenu`、`Popup` | 浮层 | 状态驱动显隐；锚点与偏移用 Modifier 与参数 |
| `Snackbar`（Coordinator 行为） | `SnackbarHost` + `Scaffold` 或手动宿主 | 底部轻提示 | 与 `SnackbarHostState` / 协程展示配合 |

#### 进度与刷新

| 旧 View | Compose | 相同点 | 不同点 |
|---------|---------|--------|--------|
| `ProgressBar`（不确定） | `CircularProgressIndicator` 等 | 加载中 | 无 indeterminate 与 determinate 两套 XML，用 **overload / 参数** 区分 |
| `SwipeRefreshLayout` | Material 的 `PullToRefresh` 容器（随 BOM 包名可能为 `pullrefresh` 相关 API） | 下拉刷新 | 与 `LazyColumn` 嵌套时注意手势冲突与官方示例 |

#### 仍建议保留 View 或 `AndroidView` 的典型场景

| 旧 View | 在 Compose 中 | 相同点 | 不同点 |
|---------|----------------|--------|--------|
| `WebView` | `AndroidView(factory = { WebView(it) })` | 内核与能力不变 | 需自行处理生命周期、文件选择、硬件加速与内存 |
| `MapView` / 三方 SDK View | `AndroidView` | 嵌入 | `update` 块里同步状态，避免泄漏 |
| 重度自定义 `onDraw` | `Canvas` / `AndroidView` | 绘制能力 | 简单形状优先 Compose `Canvas`；极复杂可先包一层 |

#### 学习顺序建议（组件维度）

1. **布局三件套**：`Column` / `Row` / `Box` + `Modifier`（对齐 View 里 Linear + Frame 的 80% 需求）。  
2. **文本与点击**：`Text`、`Modifier.clickable`、`Button`。  
3. **列表分水岭**：`LazyColumn` + `items` + `key`（对照 `RecyclerView` 心智）。  
4. **表单**：`TextField` 受控状态 + 校验展示。  
5. **应用壳**：`Scaffold` + `TopAppBar` + `NavigationBar`（对照传统 Activity + Toolbar + BottomNav）。  
6. **互操作**：`AndroidView`、`ComposeView`（对照「无法用 Compose 一步替换」的控件）。

Roadmap **阶段 2～4** 与上列顺序一致；团队可做「每周一个组件族」内部分享（文本周、列表演、壳层周）。

---

## 三、完整学习 Roadmap（基于现状：Java + View → 掌握 Compose）

下列阶段可按 **并行小步** 推进（例如业务同学主攻阶段 3～4，基础薄弱者先夯实 0～2）。**日程与「多久完成」见上文「学习与提交节奏、日期量化」**；本章各阶段后的「约 X 周」为 **全职学习量级**，工作间隙每天半小时请以该节的 **周数与目标日期** 为准。

团队可拆分专题分享；**不必赶表**，表用于防迷路而非制造焦虑。

### 阶段 0：共识与路径（约 0.5～1 周）

- 团队对齐：**不一次性重写**；约定 **新功能 / 新页面默认 Compose**（或按模块试点）。
- 建立本仓库或试点模块的 **代码完成度清单**（见后文），每个迭代勾选一两条可演示成果。
- 阅读官方 [Why Compose](https://developer.android.com/jetpack/compose/why-adopt)（可内部分享 30 分钟）。

### 阶段 1：Kotlin 最低够用集（约 1～2 周，可与阶段 2 重叠）

- 空安全、默认参数、命名参数、字符串模板。
- `data class`、密封类 `sealed interface`（用于 `UiState` 分支）。
- 高阶函数与 lambda（Compose 全是 lambda）。
- 协程入门：`suspend`、`launch`、`Flow` 基础（为 `ViewModel` + `collectAsStateWithLifecycle` 铺路）。
- **不必**先成为 Kotlin 专家；遇到再查，避免阻塞 UI 学习。

### 阶段 2：Compose 基础与布局（约 1～2 周）

- `Composable` 与 **重组**：哪些代码会重跑、如何避免在重组中做昂贵副作用。
- **Modifier 链**顺序：`padding` / `background` / `clickable` 等对测量与点击区域的影响（对照文档 **第二章 2.1～2.2 小节**）。
- 布局：`Column`、`Row`、`Box`、`Spacer`、`Modifier.weight`。
- 文本：`Text`、`TextStyle`、`AnnotatedString`；关注 BOM 版本内 **ClickableText 迁移** 说明。
- 主题：`MaterialTheme`、`Typography`、`ColorScheme`；暗色与动态颜色（本仓库已具备雏形）。

**实践目标**：在独立 `Composable` 或小 `Activity` 中完成「文本 + 点击 + 主题色」（与 `ComposeTextActivity` 对齐并扩展）。

### 阶段 3：状态与列表（约 1～2 周）

- `remember` + `mutableStateOf`、**状态提升**（与「把状态从子 View 提到 Activity」同源）。
- 副作用：`LaunchedEffect`、`DisposableEffect`（对照 `onAttachedToWindow` / 注册监听与注销）。
- 输入：`TextField`、键盘与焦点。
- 列表：`LazyColumn` / `LazyRow`、`items`、`key`、滑动与性能注意点。

**实践目标**：某一 Tab 内「搜索框 + 列表」，状态放在合适层级；为阶段 4 接入 `ViewModel` 留接口。

### 阶段 4：Material3、导航与 Android 集成（约 2～3 周）

- `Scaffold`、`TopAppBar`、`Snackbar`、`NavigationBar` 等（本仓库 Tab 已部分覆盖）。
- **Navigation Compose**：路由、`NavHost`、`popUpTo`、`launchSingleTop`、参数与可选类型安全路由（进阶）。
- **ViewModel**：`viewModel()`、`StateFlow` + `UiState`；配置变更后状态恢复。
- **生命周期感知收集**：`collectAsStateWithLifecycle`（需相应 lifecycle-compose 依赖）。

**实践目标**：至少一屏 **ViewModel + UiState**；详情带简单路由参数或返回结果。

### 阶段 5：View 与 Compose 互操作（约 2～3 周，与真实业务强相关）

见 **第四章专题**；本阶段应在仓库中留下 **可运行的小例子**（见「代码完成度」互操作小节）。

### 阶段 6：渐进式迁移策略（约持续进行）

- **绞杀者模式**：同一业务域内，新路由用 Compose，旧路由逐步下线。
- **按屏迁移**：列表页、设置页、独立流程优先；核心复杂自定义 View 可包在 `AndroidView` 内暂缓重写。
- **双栈导航**：`Fragment` + Navigation XML 与 `NavHost` 并存时，统一「返回栈」与深链策略需架构评审。

### 阶段 7：进阶与「完全学会」判定（按需，持续）

下列可作为 **高级工程师路径** 的选修与验收标准：

- 动画：`AnimatedVisibility`、`animate*AsState`、`Transition`。
- 手势与自定义：`pointerInput`、自定义 `Layout`、与嵌套滚动协调。
- 图形：`Canvas`、矢量与品牌动效。
- 测试：`ComposeTestRule`、`Semantics`、关键路径 UI 测试。
- 无障碍与大屏：语义、`contentDescription`、折叠屏 / 多窗格布局。
- **性能**：重组调试、`@Stable` / `@Immutable`、列表懒加载与基准对比。

**「完全学会」的务实定义**：能独立负责一屏从需求到上线（含状态、导航、互操作、Insets、无障碍基本项），并能指导他人做迁移切片与 Code Review；而非背诵全部 API。

---

## 四、专题：Compose 与旧 View 体系混写及通信

本章解决三类问题：**谁在宿主里**、**数据怎么传**、**事件怎么回传**。

### 4.1 在旧 View / Fragment / Activity 中嵌入 Compose

**场景**：保留 `Activity` + XML 根布局，局部用 Compose 替换或新增一块 UI。

- 布局中使用 `<androidx.compose.ui.platform.ComposeView />`，或在代码中 `ComposeView(context)`。
- 调用 `setContent { … }` 注入根 Composable；生命周期由 `ComposeView` 与 `ViewTreeLifecycleOwner` 等自动绑定（在 `Fragment` 中需保证使用 `viewLifecycleOwner` 相关实践）。
- **主题**：在 `setContent` 最外层包一层与本应用一致的 `MaterialTheme` / 项目 `ComposeKotlinStudyTheme`，避免 Compose 块与系统 XML 主题视觉割裂。

**与 Java 互调**：从 Java 持有 `ComposeView` 引用并 `setContent` 可用 Kotlin 写薄封装层（`object` / `file` 级 `@JvmStatic`），Java 调 Kotlin 推荐渐进式。

### 4.2 在 Compose 中嵌入旧 View

**场景**：地图、播放器、遗留自定义 `View`、第三方 SDK 只提供 View。

- 使用 **`AndroidView(factory = { … }, update = { … })`**：`factory` 创建 View，`update` 在重组时同步状态到 View（避免在 `factory` 里做会随状态变化而应刷新的逻辑）。
- 注意 **View 状态保存**、内存泄漏（`DisposableEffect` 里 `release` / 注销监听）。
- 测量行为与 Compose 布局约束可能不一致，需阅读官方 **Interop** 文档中的限制与建议。

### 4.3 老页面与 Compose 页面之间的通信（推荐优先级）

下列方式与团队是否已使用 `Fragment`、是否统一 `ViewModel` 强相关，可按优先级组合。

1. **共享 ViewModel（同 Activity 作用域或 Navigation 图作用域）**  
   - Java 的 `ViewModelProvider(activity).get(FooViewModel.class)` 与 Kotlin `activityViewModel()` 等形式，本质是同一作用域。  
   - 用 **`StateFlow` / `LiveData`** 暴露只读状态；Compose 侧 `collectAsStateWithLifecycle`；View 侧继续 `observe` 或 `repeatOnLifecycle`。  
   - **适合**：同一屏内 Compose + XML 并存、或 Tab 内多子页共享业务状态。

2. **接口回调 / 监听器**  
   - Activity 实现接口，Compose 通过 `CompositionLocal` 或构造参数传入 `onXxx: () -> Unit`；XML 侧 `setListener`。  
   - **适合**：一次性事件、导航指令（如「关闭当前页」「打开设置」）。

3. **`FragmentResult` / Navigation 返回结果**  
   - 在 Fragment 体系内，Compose 目的地与 XML 目的地可通过 **`FragmentManager.setFragmentResult`** 或 Navigation 的 **savedStateHandle** 传结果。  
   - **适合**：A 屏选完数据回 B 屏。

4. **`ActivityResultContracts` / `registerForActivityResult`**  
   - 权限、系统选择器、跨 Activity 结果；Compose 可用 `rememberLauncherForActivityResult`。  
   - **适合**：与 UI 技术栈无关的系统级契约。

5. **单例 / EventBus（不推荐作为默认）**  
   - 全局总线难测、难生命周期对齐；仅遗留项目短期桥接时可谨慎使用，新代码优先 1～4。

6. **跨进程 / AIDL / ContentProvider**  
   - 与 Compose 无关；仅当业务涉及多进程时按原 Android 模型处理。

### 4.4 混写常见坑（团队可做成 Checklist）

- **主题与夜间模式**：Compose 主题与 XML `Theme` 不同步会导致闪屏或色块不一致；尽量共用色值资源或单一数据源。
- **WindowInsets**：一半屏幕 Compose、一半 XML 时，各自处理 `fitsSystemWindows` / `padding` 容易重复或遗漏；建议统一在 Activity/根 `Fragment` 策略层决策。
- **返回键**：`Dialog` / `BottomSheet` + `BackHandler` 与 `onBackPressed` 需统一优先级，避免双击返回异常。
- **RecyclerView 内嵌 Compose**：可用 `ComposeView` 作为 item，注意 **viewType 与回收** 导致的 `DisposableEffect` 清理。

---

## 五、当前项目快照（本仓库）

| 项 | 说明 |
|----|------|
| 包名 | `com.example.composekotlinstudy` |
| Compose | 已启用，`compose-bom` + Material3 |
| 导航 | `navigation-compose`，双层 `NavHost`（根路由 + Tab 内路由） |
| 系统 UI | `enableEdgeToEdge()` + `WindowCompat.setDecorFitsSystemWindows(false, …)` |
| 主题 | `ComposeKotlinStudyTheme`（含动态取色，Android 12+） |

---

## 六、代码完成度（对照本仓库）

在下列条目前使用 `[x]` 表示已完成，`[ ]` 表示未开始或未完成。

### 6.1 工程与依赖

- [x] Gradle 启用 Compose、`composeOptions`、`compose-bom`
- [x] Material3、Activity Compose、Navigation Compose 依赖
- [ ] `lifecycle-runtime-compose`、`lifecycle-viewmodel-compose`（便于 `collectAsStateWithLifecycle` / `viewModel()`）

### 6.2 主题与资源

- [x] `Color.kt` / `Type.kt` / `Theme.kt` 基础结构
- [x] 动态颜色（Android 12+）
- [ ] 按需补全 `Typography` 全字阶与行高，与产品设计对齐

### 6.3 导航与壳层

- [x] `TabBarPage`：根 `NavHost` + Tab 内 `NavHost`
- [x] `NavigationRoutes`：根路由与 Tab 枚举
- [x] `TabScreens`：首页 / 发现 / 我的 Tab 内容 + `DetailScreen` 返回栈
- [ ] 详情页路由参数（例如 `id`）与返回结果（`SavedStateHandle` / callback）
- [ ] 横屏或大屏下的布局分支（可选）

### 6.4 示例页面与 Activity

- [x] `MainActivity`：`setContent` + `TabBarPage` + Edge-to-edge
- [x] `ComposeTextActivity`：`Text` / `ClickableText` / `TextStyle` / 字体与长文本示例
- [ ] `MainActivity` 中的 `Greeting`、`studyMenus`：与主导航整合或迁入独立「学习目录」页，避免死代码
- [ ] `ui/page/TestPage.kt`：与 `NavHost` 打通或删除；与 `ComposeUITextSample` 保持单一事实来源

### 6.5 状态与列表（待建设）

- [ ] `ViewModel` + `UiState` 示例页
- [ ] `LazyColumn` 分页或占位数据列表
- [ ] `TextField` 表单校验示例

### 6.6 系统栏与 Edge-to-edge

- [x] 启用 Edge-to-edge 与 `setDecorFitsSystemWindows(false)`
- [ ] `WindowInsets` / `Modifier.safeDrawingPadding` 等统一处理状态栏、导航栏与 IME

### 6.7 View / Compose 互操作与通信（强烈建议补示例）

- [ ] **Compose 嵌入 XML**：示例 `Activity` + 根 XML 含 `ComposeView`，与纯 `setContent` 页面对照
- [ ] **AndroidView 包裹**：示例自定义 `View`（或 `TextView`）在 Compose 中展示并双向同步简单状态
- [ ] **共享 ViewModel**：同一 `Activity` 下 XML `Fragment` 与 Compose 屏同时订阅同一 `StateFlow` 的 Demo
- [ ] **返回结果**：Compose → Compose 或 Compose → Fragment 传递选择结果（`SavedStateHandle` / `FragmentResult` 二选一演示）

### 6.8 测试

- [ ] 为关键 `Composable` 增加 `@Preview`（多设备、暗色）
- [ ] `androidTest` 中至少一条 Compose UI 测试（点击 Tab、进入详情、返回）

---

## 七、建议的近期 Todo（看板可复制）

1. 整理 `MainActivity`：移除或接入未使用的 `studyMenus` / `Greeting`。
2. 统一「文本示例」入口：Tab 子路由或保留 Activity 并在文档注明适用场景。
3. 选一 Tab：`LazyColumn` + 假数据 + `key` + 点击进入详情（带参数）。
4. 引入 `ViewModel` + `StateFlow` + `UiState`，并加 `collectAsStateWithLifecycle`。
5. 补齐 Insets：`Scaffold` / 根布局与 IME 不遮挡可点击区域。
6. **新增互操作最小样例**：`ComposeView` in XML + `AndroidView` 各一；共享 `ViewModel` 传一条字符串双向验证。

---

## 八、参考文档

- [Why adopt Compose](https://developer.android.com/jetpack/compose/why-adopt)
- [Jetpack Compose 官方文档](https://developer.android.com/jetpack/compose)
- [Interoperability APIs](https://developer.android.com/jetpack/compose/interop/interop-apis)（ComposeView、AndroidView）
- [Material 3 for Compose](https://m3.material.io/develop/android/jetpack-compose)
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- [Lifecycle-aware collection](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)（与 `collectAsStateWithLifecycle` 搭配）

---

*文档置于仓库根目录；Roadmap 随团队现状可删减阶段编号，互操作章节建议与业务架构评审同步更新。*
