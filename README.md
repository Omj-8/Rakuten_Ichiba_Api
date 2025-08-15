# 楽天市場商品検索アプリ（練習用）

このプロジェクトは、**Kotlin** と **Jetpack Compose** を用いて作成した練習用アプリです。  
楽天市場の **商品検索API** を利用し、キーワード検索から商品一覧表示、商品詳細画面への遷移までを実装しています。

## 📱 機能概要
- **商品検索**：キーワードを入力して楽天市場から商品データを取得
- **商品一覧表示**：取得した商品名・価格をリスト形式で表示
- **詳細画面遷移**：商品をタップすると楽天市場の商品ページをブラウザで開く
- **画面遷移**：`Navigation` を用いた Compose 画面間の遷移

## 🛠 技術スタック
- 言語：Kotlin
- UI：Jetpack Compose (Material3)
- アーキテクチャ：ViewModel + StateFlow
- 通信：Retrofit2 + Gson
- 画面遷移：Navigation Compose
- API：楽天市場商品検索API（IchibaItem/Search）


## ⚠️ 注意事項
- このリポジトリの `appId` はダミー値です。本物の楽天APIキーは含まれていません。
- 公開環境で使用する際は、APIキーを **local.properties** や環境変数で安全に管理してください。

## 📖 参考
- [楽天市場API公式ドキュメント](https://webservice.rakuten.co.jp/api/ichibaitemsearch/)
- [Jetpack Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- [Retrofit公式ドキュメント](https://square.github.io/retrofit/)

