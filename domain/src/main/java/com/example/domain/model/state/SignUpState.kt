package com.example.domain.model.state

enum class SignUpState {
    Loading {
        override fun toString(): String = "로딩중..."
    },
    None {
        override fun toString(): String = "none"
    },
    Main {
        override fun toString(): String = "회원가입 완료. 환영합니다!!"
    },
    Duplicate {
        override fun toString(): String = "중복된 이메일입니다."
    },
    Failed {
        override fun toString(): String = "오류 발생. 잠시 후 시도해주세요."
    };

    abstract override fun toString(): String
}
