INSERT INTO categories (name)
VALUES
    ('乳製品'),
    ('パン'),
    ('飲料'),
    ('菓子'),
    ('果物'),
    ('野菜'),
    ('精肉'),
    ('冷凍食品'),
    ('シリアル'),
    ('調味料');

INSERT INTO products (name, price, description, category_id)
VALUES
    (
        '明治おいしい牛乳 900ml',
        298.00,
        '生乳本来のおいしさを生かした牛乳。まろやかなコクとすっきりした後味が特徴です。',
        (SELECT id FROM categories WHERE name = '乳製品' LIMIT 1)
    ),
    (
        'ヤマザキ ロイヤルブレッド 6枚切',
        198.00,
        'しっとりとした食感と小麦の風味が楽しめる食パン。トーストやサンドイッチにおすすめです。',
        (SELECT id FROM categories WHERE name = 'パン' LIMIT 1)
    ),
    (
        'コカ・コーラ 500ml',
        158.00,
        '世界中で親しまれている炭酸飲料。独特の風味と爽快感が特徴です。',
        (SELECT id FROM categories WHERE name = '飲料' LIMIT 1)
    ),
    (
        'カルビー ポテトチップス うすしお味 60g',
        148.00,
        '国産じゃがいもを使用したポテトチップス。ほどよい塩味とパリッとした食感が楽しめます。',
        (SELECT id FROM categories WHERE name = '菓子' LIMIT 1)
    ),
    (
        'フィリピン産 バナナ 1房',
        198.00,
        '甘みがあり、そのまま手軽に食べられるバナナ。朝食やおやつにおすすめです。',
        (SELECT id FROM categories WHERE name = '果物' LIMIT 1)
    ),
    (
        '国産 にんじん 3本入り',
        198.00,
        '国内で栽培された新鮮なにんじん。カレーや煮物、サラダなど幅広い料理に利用できます。',
        (SELECT id FROM categories WHERE name = '野菜' LIMIT 1)
    ),
    (
        '国産 若鶏むね肉 300g',
        298.00,
        '脂肪が比較的少なく、たんぱく質を豊富に含む国産鶏むね肉。唐揚げや蒸し鶏などにおすすめです。',
        (SELECT id FROM categories WHERE name = '精肉' LIMIT 1)
    ),
    (
        '味の素 ギョーザ 12個入り 276g',
        298.00,
        '油や水を使わずにフライパンで調理できる冷凍ギョーザ。パリッとした羽根とジューシーな具が特徴です。',
        (SELECT id FROM categories WHERE name = '冷凍食品' LIMIT 1)
    ),
    (
        '日清シスコ ごろグラ 贅沢果実 280g',
        498.00,
        '果実を使用したグラノーラ。牛乳やヨーグルトと一緒に朝食として楽しめます。',
        (SELECT id FROM categories WHERE name = 'シリアル' LIMIT 1)
    ),
    (
        'キッコーマン いつでも新鮮 しぼりたて生しょうゆ 450ml',
        328.00,
        '火入れをしない製法で作られた生しょうゆ。鮮やかな色と豊かな香りが特徴で、さまざまな料理に使えます。',
        (SELECT id FROM categories WHERE name = '調味料' LIMIT 1)
    );

