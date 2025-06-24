import tensorflow as tf
import numpy as np
import os
from tensorflow.keras.applications import EfficientNetB5



train_ds = tf.keras.preprocessing.image_dataset_from_directory(
    '/content/dataset/',          # 수정해야함 이건 코랩에서 쓰는거
    image_size = (380, 380),      #B5모델 인풋 크기
    batch_size = 64,         
    subset = 'training',
    validation_split = 0.2,  
    seed = 1234              
)

val_ds = tf.keras.preprocessing.image_dataset_from_directory(
    '/content/dataset/',
    image_size = (380, 380),   
    batch_size = 64,         
    subset = 'validation',
    validation_split = 0.2,
    seed = 1234
)


Effi_model = EfficientNetB5(weights='imagenet')    # 모델 부르는거

Effi_model.trainable = False  # 아래 직접 작성해준 레이어를 제외한 불러온 레이어는 트레이닝 안함

label_variAtion = 12

last_layer = Effi_model.get_layer('predictions')

layer1 = tf.keras.layers.Flatten()(last_layer.output)
layer2 = tf.keras.layers.Dense(518, activation='relu')(layer1)
layer3 = tf.keras.layers.Dense(254, activation='relu')(layer2)
drop1 = tf.keras.layers.Dropout(0.4)(layer3)
layer4 = tf.keras.layers.Dense(label_variAtion, activation='softmax')(drop1)

model = tf.keras.Model(Effi_model.input, layer4)


callback_func = tf.keras.callbacks.ModelCheckpoint(
    filepath='ckpt/mnist',   # 경로 수정 해야함
    monitor = 'val_acc',
    mode='max',
    save_weights_only = True,
    save_freq = 'epoch'
)

model.compile(loss = 'sparse_categorical_crossentropy',optimizer='adam',metrics=['acc'])
model.fit(train_ds, validation_data=val_ds, epochs=5, callbacks=[callback_func])  

# epochs 5~6번이면 충분할듯
# 가중치가 거의 다 이미 정해져있는걸 가져다 쓰는 형태라서
# 입력해준 레이어만 추가로 훈련시켜주면 댐

model.save("my_model.h5")