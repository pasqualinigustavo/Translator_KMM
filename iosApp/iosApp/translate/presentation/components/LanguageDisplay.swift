//
//  LanguageDisplay.swift
//  iosApp
//
//  Created by Gustavo Luiz Pasqualini on 29/06/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDisplay: View {
    var language: UiLanguage
    
    var body: some View {
        HStack {
            SmallLanguageIcon(language: language)
                .padding(.trailing, 5)
            Text(language.language.langName)
                .foregroundColor(.lightBlue)
        }
    }
}

struct LanguageDisplay_Previews: PreviewProvider {
    static var previews: some View {
        LanguageDisplay(
            language: UiLanguage(language: .german, imageName: "german")
        )
    }
}
