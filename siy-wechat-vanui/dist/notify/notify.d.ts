interface NotifyOptions {
    color?: string;
    zIndex?: number;
    message: string;
    context?: any;
    duration?: number;
    selector?: string;
    background?: string;
    safeAreaInsetTop?: boolean;
}
export default function Notify(options: NotifyOptions | string): void;
export {};
