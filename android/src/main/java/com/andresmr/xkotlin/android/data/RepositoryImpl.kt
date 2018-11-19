package com.andresmr.xkotlin.android.data

import com.andresmr.xkotlin.common.data.Repository
import com.andresmr.xkotlin.common.entity.Item
import com.google.firebase.firestore.FirebaseFirestore

class RepositoryImpl : Repository {
    private val collection = "items"
    private val source = FirebaseFirestore.getInstance()

    override fun add(item: Item, onSuccess: () -> Unit, onError: (message: String) -> Unit) {
        val data = HashMap<String, Any>()
        data.put("name", item.name)
        data.put("description", item.description)

        source.collection(collection)
                .add(data)
                .addOnSuccessListener {
                    onSuccess()
                }
                .addOnFailureListener {
                    onError("Error adding item")
                }
    }

    override fun getItems(onSuccess: (items: List<Item>) -> Unit, onError: (message: String) -> Unit) {
        source.collection(collection)
                .get()
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        val items = ArrayList<Item>()
                        for (document in task.result) {
                            document.data.apply {
                                val item = Item(get("name") as String, get("description") as String)
                                items.add(item)
                            }
                        }
                        onSuccess(items)
                    }
                    else {
                        onError("Error obtaining items")
                    }
                })
    }
}