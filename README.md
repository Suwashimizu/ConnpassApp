this application is to search events from connpass

## API

https://connpass.com/about/api/

## CleanArchitecture

module以下にCleanArchitectureに関するものを纏めています  
mapperは本来含まれていませんがTestableにするため追加してます


```
app/src/main/java/org/suwashizmu/connpassapp/module
├── controller
│   └── EventSearchController.kt
├── entity
│   └── Event.kt
├── input
│   └── EventSearchInputData.kt
├── mapper
│   └── EventMapper.kt
├── output
│   └── EventSearchOutputData.kt
├── presenter
│   ├── EventSearchPresenter.kt
│   └── IEventSearchPresenter.kt
├── repository
│   ├── EventRepository.kt
│   └── RemoteEventDataSource.kt
├── usecase
│   ├── EventSearchInteractor.kt
│   └── IEventSearchUseCase.kt
└── view
    ├── ISearchEventView.kt
    └── SearchEventViewModel.kt
```

## 組み立て方

Entity→UseCase→Input&Output→
Repository→DataSource→
Presenter→ViewModel→Interactor→
Controller→View



## 参考URL
https://qiita.com/nrslib/items/a5f902c4defc83bd46b8

OutputPortを定義してないのが不明瞭でしたが  
概ね上から順に実装していけばテスト書きつつ進めることができました:bow:  
